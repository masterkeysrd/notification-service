package com.masterkeys.notificationservice.service.impl;

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
    private final CategoryService categoryService;
    private final NotificationServiceFactory notificationServiceFactory;
    private final NotificationRecorderService notificationRecorderService;

    public NotificationManagerServiceImpl(
            UserService userService,
            CategoryService categoryService,
            NotificationServiceFactory notificationServiceFactory,
            NotificationRecorderService notificationRecorderService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.notificationServiceFactory = notificationServiceFactory;
        this.notificationRecorderService = notificationRecorderService;
    }

    @Override
    @Async
    public CompletableFuture<Void> fanOut(FanOutNotificationRequest request) {
        logger.debug("Sending notification {}", request);

        var categoryOpt = categoryService.getById(request.category());

        if (categoryOpt.isEmpty()) {
            logger.warn("No category found for id {}", request.category());
            return CompletableFuture.completedFuture(null);
        }

        userService.getSubscribedUsersByTopic(request.category())
                .users()
                .parallelStream()
                .flatMap(user -> user.channels().stream()
                        .map(channel -> ChannelNotification.of(request, categoryOpt.get(), channel,
                                Recipient.of(user))))
                .forEach(this::process);

        return CompletableFuture.completedFuture(null);
    }

    private void process(ChannelNotification channelNotification) {
        logger.debug("Sending notification to channel {} for recipient {}", channelNotification.channel(),
                channelNotification.recipient());

        var notificationServiceOpt = notificationServiceFactory.get(channelNotification.channel());

        if (notificationServiceOpt.isPresent()) {
            var notificationService = notificationServiceOpt.get();
            var request = SendNotificationRequest.of(channelNotification.recipient(), channelNotification.message());
            var response = notificationService.send(request);

            notificationRecorderService.record(
                    RecordNotificationRequest.of(response.notificationId(), response.userId(),
                            channelNotification.categoryId(), channelNotification.categoryName(), response.channel(),
                            response.destination(), response.message(), response.status(), response.timestamp()));

        } else {
            logger.warn("No service found for channel {}", channelNotification.channel());
        }

    }

    private static record ChannelNotification(String categoryId, String categoryName, Channel channel,
            Recipient recipient, String message) {
        static ChannelNotification of(FanOutNotificationRequest request, GetCategoryResponseItem category,
                Channel channel, Recipient recipient) {
            return new ChannelNotification(category.id(), category.name(), channel, recipient,
                    request.message());
        }
    }
}
