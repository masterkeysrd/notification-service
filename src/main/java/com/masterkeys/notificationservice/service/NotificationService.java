package com.masterkeys.notificationservice.service;

import com.masterkeys.notificationservice.service.dto.Recipient;
import com.masterkeys.notificationservice.service.dto.SendNotificationResponse;

public interface NotificationService {
    SendNotificationResponse send(String message, Recipient recipient);
}
