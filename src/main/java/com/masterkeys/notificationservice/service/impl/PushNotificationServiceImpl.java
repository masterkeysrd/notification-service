package com.masterkeys.notificationservice.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.service.PushNotificationService;
import com.masterkeys.notificationservice.service.dto.Recipient;
import com.masterkeys.notificationservice.service.dto.SendNotificationResponse;
import com.masterkeys.notificationservice.utils.SimulatorUtil;

@Service
public class PushNotificationServiceImpl implements PushNotificationService {
    private final Logger logger = LoggerFactory.getLogger(PushNotificationServiceImpl.class);

    public SendNotificationResponse send(String message, Recipient recipient) {
        logger.debug("Sending push notification to {} with message: {}", recipient.deviceToken(), message);

        // Simulate the time it takes to send a push notification
        SimulatorUtil.simulateWork();

        var id = UUID.randomUUID();
        return SendNotificationResponse.of(id, recipient.id(), Channel.PUSH, recipient.deviceToken(), message,
                (int) (System.currentTimeMillis() / 1000), "SENT");
    }
}
