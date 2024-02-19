package com.masterkeys.notificationservice.service;

import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;

public interface NotificationManagerService {
    void sendNotification(SendNotificationRequest request);
}
