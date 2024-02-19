package com.masterkeys.notificationservice.web.res;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masterkeys.notificationservice.service.dto.SendMessageRequest;
import com.masterkeys.notificationservice.service.dto.SendMessageResponse;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    Logger logger = LoggerFactory.getLogger(MessageController.class);

    @PostMapping("")
    public SendMessageResponse sendMessage(@RequestBody SendMessageRequest request) {
        logger.debug("REST request to send message: {}", request);
        return new SendMessageResponse("Message sent successfully");
    }
}
