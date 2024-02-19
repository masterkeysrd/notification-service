package com.masterkeys.notificationservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.service.PushNotificationService;
import com.masterkeys.notificationservice.service.dto.Recipient;
import com.masterkeys.notificationservice.utils.SimulatorUtil;

@Service
public class PushNotificationServiceImpl implements PushNotificationService {
    private final Logger logger = LoggerFactory.getLogger(PushNotificationServiceImpl.class);

    public void send(String message, Recipient recipient) {
        logger.debug("Sending push notification to {} with message: {}", recipient.deviceToken(), message);

        // Simulate the time it takes to send a push notification
        SimulatorUtil.simulateWork();
    }
}
