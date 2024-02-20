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

        var subscribedUsers = userService.getSubscribedUsersByTopic(request.category());
        subscribedUsers.users().parallelStream()
                .flatMap(user -> user.channels().stream()
                        .map(channel -> SendChannelNotificationRequest.from(request, channel, Recipient.of(user))))
                .forEach(this::processNotification);

        return CompletableFuture.completedFuture(null);
    }

    private Optional<NotificationService> getNotificationService(Channel channel) {
        return Optional.ofNullable(notificationServices.get(channel));
    }

    private void processNotification(SendChannelNotificationRequest request) {
        logger.debug("Sending notification to channel {} for recipient {}", request.channel(), request.recipient());

        getNotificationService(request.channel())
                .ifPresentOrElse(
                        service -> {
                            SendNotificationResponse response = service.send(request.message(), request.recipient());
                            notificationRecorderService.record(RecordNotificationRequest.of(response.notificationId(),
                                    response.userId(), response.channel(), response.destination(), response.message(),
                                    response.status(), response.timestamp()));

                        }, () -> logger.warn("No service found for channel {}", request.channel()));
    }
}
