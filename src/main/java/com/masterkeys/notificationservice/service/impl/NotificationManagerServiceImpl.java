package com.masterkeys.notificationservice.service.impl;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.service.*;
import com.masterkeys.notificationservice.service.dto.*;

@Service
public class NotificationManagerServiceImpl implements NotificationManagerService {
    private final Logger logger = LoggerFactory.getLogger(NotificationManagerServiceImpl.class);

    private final UserService userService;
    private final NotificationRecorderService notificationRecorderService;

    private final Map<Channel, NotificationService> notificationServices;

    public NotificationManagerServiceImpl(UserService userService, EmailNotificationService emailNotificationService,
            PushNotificationService pushNotificationService, SMSNotificationService smsNotificationService,
            NotificationRecorderService notificationRecorderService) {

        this.userService = userService;
        this.notificationRecorderService = notificationRecorderService;

        notificationServices = Map.of(
                Channel.EMAIL, emailNotificationService,
                Channel.PUSH, pushNotificationService,
                Channel.SMS, smsNotificationService);
    }

    @Override
    @Async
    public CompletableFuture<Void> fanOut(FanOutNotificationRequest request) {
        logger.debug("Sending notification {}", request);

        userService.getSubscribedUsersByTopic(request.category())
                .users()
                .parallelStream()
                .flatMap(user -> user.channels().stream()
                        .map(channel -> ChannelNotification.of(request, channel, Recipient.of(user))))
                .forEach(this::process);

        return CompletableFuture.completedFuture(null);
    }

    private Optional<NotificationService> getNotificationService(Channel channel) {
        return Optional.ofNullable(notificationServices.get(channel));
    }

    private void process(ChannelNotification channelNotification) {
        logger.debug("Sending notification to channel {} for recipient {}", channelNotification.channel(),
                channelNotification.recipient());

        var notificationServiceOpt = getNotificationService(channelNotification.channel());

        if (notificationServiceOpt.isPresent()) {
            var notificationService = notificationServiceOpt.get();
            var request = SendNotificationRequest.of(channelNotification.recipient(), channelNotification.message());
            var response = notificationService.send(request);

            notificationRecorderService.record(
                    RecordNotificationRequest.of(response.notificationId(), response.userId(), response.channel(),
                            response.destination(), response.message(), response.status(), response.timestamp()));

        } else {
            logger.warn("No service found for channel {}", channelNotification.channel());
        }

    }

    private static record ChannelNotification(Channel channel, Recipient recipient, String message) {
        static ChannelNotification of(FanOutNotificationRequest request, Channel channel, Recipient recipient) {
            return new ChannelNotification(channel, recipient, request.message());
        }
    }
}
