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

    private final Map<Channel, NotificationService> notificationServices;

    public NotificationManagerServiceImpl(UserService userService, EmailNotificationService emailNotificationService,
            PushNotificationService pushNotificationService, SMSNotificationService smsNotificationService) {
        this.userService = userService;

        notificationServices = Map.of(
                Channel.EMAIL, emailNotificationService,
                Channel.PUSH, pushNotificationService,
                Channel.SMS, smsNotificationService);
    }

    @Override
    @Async
    public CompletableFuture<Void> sendNotification(SendNotificationRequest request) {
        logger.debug("Sending notification {}", request);

        var subscribedUsers = userService.getSubscribedUsersByTopic(request.getCategory());
        subscribedUsers.getUsers().parallelStream()
                .flatMap(user -> user.getChannels().stream()
                        .map(channel -> SendChannelNotificationRequest.from(request, channel, Recipient.from(user))))
                .forEach(this::processNotification);

        return CompletableFuture.completedFuture(null);
    }

    private Optional<NotificationService> getNotificationService(Channel channel) {
        return Optional.ofNullable(notificationServices.get(channel));
    }

    private void processNotification(SendChannelNotificationRequest request) {
        logger.debug("Sending notification to channel {} for recipient {}", request.channel(), request.recipient());

        getNotificationService(request.channel()).ifPresentOrElse(
                notificationService -> sendNotificationWithService(request, notificationService),
                () -> logger.error("No notification service found for channel {}", request.channel()));
    }

    private void sendNotificationWithService(SendChannelNotificationRequest request,
            NotificationService notificationService) {
        logger.debug("Sending notification to channel {} for recipient {}", request.channel(), request.recipient());

        try {
            notificationService.send(request.message(), request.recipient());
        } catch (Exception e) {
            logger.error("Failed to send notification to channel {} for recipient {}", request.channel(),
                    request.recipient(), e);
        }
    }
}
