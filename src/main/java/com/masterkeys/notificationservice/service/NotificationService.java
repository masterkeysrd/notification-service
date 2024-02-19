package com.masterkeys.notificationservice.service;

import com.masterkeys.notificationservice.service.dto.Recipient;

public interface NotificationService {
    void send(String message, Recipient recipient);
}
