package com.masterkeys.notificationservice.service.impl;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.masterkeys.notificationservice.service.MessageService;
import com.masterkeys.notificationservice.service.NotificationManagerService;
import com.masterkeys.notificationservice.service.dto.SendMessageRequest;
import com.masterkeys.notificationservice.service.dto.SendMessageResponse;
import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;

@Service
public class MessageServiceImpl implements MessageService {
    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final NotificationManagerService notificationManagerService;

    public MessageServiceImpl(NotificationManagerService notificationManagerService) {
        this.notificationManagerService = notificationManagerService;
    }

    public SendMessageResponse send(SendMessageRequest request) {
        logger.debug("Sending message {}", request);
        var notificationRequest = new SendNotificationRequest(
                request.getMessage(),
                request.getCategory());

        notificationManagerService.sendNotification(notificationRequest);

        return new SendMessageResponse("Message started to be processed");
    }
}
