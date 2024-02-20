package com.masterkeys.notificationservice.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.service.SMSNotificationService;
import com.masterkeys.notificationservice.service.dto.Recipient;
import com.masterkeys.notificationservice.service.dto.SendNotificationResponse;
import com.masterkeys.notificationservice.utils.SimulatorUtil;

@Service
public class SMSNotificationServiceImpl implements SMSNotificationService {
    private final Logger logger = LoggerFactory.getLogger(SMSNotificationServiceImpl.class);

    public SendNotificationResponse send(String message, Recipient recipient) {
        logger.debug("Sending SMS notification to {} with message: {}", recipient.phoneNumber(), message);

        // Simulate the time it takes to send an SMS
        SimulatorUtil.simulateWork();

        var id = UUID.randomUUID();
        return SendNotificationResponse.of(id, recipient.id(), Channel.SMS, recipient.phoneNumber(), message,
                (int) (System.currentTimeMillis() / 1000), "SENT");
    }
}
