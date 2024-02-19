package com.masterkeys.notificationservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.service.NotificationManagerService;
import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;

@Service
public class NotificationManagerServiceImpl implements NotificationManagerService {
    private final Logger logger = LoggerFactory.getLogger(NotificationManagerServiceImpl.class);

    @Override
    public void sendNotification(SendNotificationRequest request) {
        logger.debug("Sending notification {}", request);
    }   
}
