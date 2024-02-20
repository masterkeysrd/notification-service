package com.masterkeys.notificationservice.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.service.SMSNotificationService;
import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;
import com.masterkeys.notificationservice.service.dto.SendNotificationResponse;
import com.masterkeys.notificationservice.utils.SimulatorUtil;

@Service
public class SMSNotificationServiceImpl implements SMSNotificationService {
    private final Logger logger = LoggerFactory.getLogger(SMSNotificationServiceImpl.class);

    public SendNotificationResponse send(SendNotificationRequest request) {
        logger.debug("Sending SMS notification to {} with message: {}", request.recipient(), request.message());

        // Simulate the time it takes to send an SMS
        SimulatorUtil.simulateWork();

        var id = UUID.randomUUID();
        var timestamp = (int) (System.currentTimeMillis() / 1000);
        var recipient = request.recipient();

        return SendNotificationResponse.of(id, recipient.id(), Channel.SMS, recipient.phoneNumber(), request.message(),
                timestamp, "SENT");
    }
}
