package com.masterkeys.notificationservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.service.NotificationManagerService;
import com.masterkeys.notificationservice.service.UserService;
import com.masterkeys.notificationservice.service.dto.Recipient;
import com.masterkeys.notificationservice.service.dto.SendChannelNotificationRequest;
import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;

@Service
public class NotificationManagerServiceImpl implements NotificationManagerService {
    private final Logger logger = LoggerFactory.getLogger(NotificationManagerServiceImpl.class);

    private final UserService userService;

    public NotificationManagerServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void sendNotification(SendNotificationRequest request) {
        logger.debug("Sending notification {}", request);

        var subscribedUsers = userService.getSubscribedUsersByTopic(request.getCategory());
        subscribedUsers.getUsers().parallelStream().flatMap(user -> {
            return user.getChannels().stream().map(channel -> {
                // Sleep for 1 second to simulate the time it takes to send a notification
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return new SendChannelNotificationRequest(request.getMessage(), channel, Recipient.from(user));
            });
        }).forEach(sendChannelNotificationRequest -> {
            logger.debug("Sending notification to channel {} for recipient {}",
                    sendChannelNotificationRequest.channel(), sendChannelNotificationRequest.recipient());
        });
    }
}
