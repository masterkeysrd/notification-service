package com.masterkeys.notificationservice.service;

import com.masterkeys.notificationservice.service.dto.SendMessageRequest;
import com.masterkeys.notificationservice.service.dto.SendMessageResponse;

public interface MessageService {
    SendMessageResponse send(SendMessageRequest request);
}
