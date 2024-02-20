package com.masterkeys.notificationservice.service.impl;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.masterkeys.notificationservice.service.MessageService;
import com.masterkeys.notificationservice.service.NotificationManagerService;
import com.masterkeys.notificationservice.service.dto.FanOutNotificationRequest;
import com.masterkeys.notificationservice.service.dto.SendMessageRequest;
import com.masterkeys.notificationservice.service.dto.SendMessageResponse;

@Service
public class MessageServiceImpl implements MessageService {
    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    private final NotificationManagerService notificationManagerService;

    public MessageServiceImpl(NotificationManagerService notificationManagerService) {
        this.notificationManagerService = notificationManagerService;
    }

    public SendMessageResponse send(SendMessageRequest request) {
        logger.debug("Sending message {}", request);
        var notificationRequest = FanOutNotificationRequest.of(
                request.message(),
                request.category());

        notificationManagerService.fanOut(notificationRequest);

        return SendMessageResponse.of("Message started processing");
    }
}
