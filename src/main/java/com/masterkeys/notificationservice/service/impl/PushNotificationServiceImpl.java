package com.masterkeys.notificationservice.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.service.PushNotificationService;
import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;
import com.masterkeys.notificationservice.service.dto.SendNotificationResponse;
import com.masterkeys.notificationservice.utils.SimulatorUtil;

@Service
public class PushNotificationServiceImpl implements PushNotificationService {
    private final Logger logger = LoggerFactory.getLogger(PushNotificationServiceImpl.class);

    public SendNotificationResponse send(SendNotificationRequest request) {
        logger.debug("Sending push notification to {} with message: {}", request.recipient(), request.message());

        // Simulate the time it takes to send a push notification
        SimulatorUtil.simulateWork();

        var id = UUID.randomUUID().toString();
        var timestamp = (int) (System.currentTimeMillis() / 1000);
        var recipient = request.recipient();

        return SendNotificationResponse.of(id, recipient.id(), Channel.PUSH, recipient.deviceToken(), request.message(),
                timestamp, "SENT");
    }
}
