package com.masterkeys.notificationservice.service.impl;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.masterkeys.notificationservice.service.MessageService;
import com.masterkeys.notificationservice.service.dto.SendMessageRequest;
import com.masterkeys.notificationservice.service.dto.SendMessageResponse;

@Service
public class MessageServiceImpl implements MessageService {
    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    public SendMessageResponse send(SendMessageRequest request) {
        logger.debug("Sending message {}", request);
        return new SendMessageResponse("Message sent successfully");
    }
}
