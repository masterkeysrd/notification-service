package com.masterkeys.notificationservice.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.service.EmailNotificationService;
import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;
import com.masterkeys.notificationservice.service.dto.SendNotificationResponse;
import com.masterkeys.notificationservice.utils.SimulatorUtil;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
    private final Logger logger = LoggerFactory.getLogger(EmailNotificationServiceImpl.class);

    public SendNotificationResponse send(SendNotificationRequest request) {
        logger.debug("Sending email notification to {} with message: {}", request.recipient(), request.message());

        // Simulate the time it takes to send an email
        SimulatorUtil.simulateWork();

        var id = UUID.randomUUID();
        var recipient = request.recipient();
        var timestamp = (int) (System.currentTimeMillis() / 1000);

        return SendNotificationResponse.of(id, recipient.id(), Channel.EMAIL, recipient.email(),
                request.message(), timestamp, "SENT");
    }
}
