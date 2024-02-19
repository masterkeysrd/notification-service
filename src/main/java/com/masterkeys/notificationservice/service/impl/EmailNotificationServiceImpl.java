package com.masterkeys.notificationservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.service.EmailNotificationService;
import com.masterkeys.notificationservice.service.dto.Recipient;
import com.masterkeys.notificationservice.utils.SimulatorUtil;

@Service
public class EmailNotificationServiceImpl implements EmailNotificationService {
    private final Logger logger = LoggerFactory.getLogger(EmailNotificationServiceImpl.class);

    public void send(String message, Recipient recipient) {
        logger.debug("Sending email notification to {} with message: {}", recipient.email(), message);

        // Simulate the time it takes to send an email
        SimulatorUtil.simulateWork();
    }
}
