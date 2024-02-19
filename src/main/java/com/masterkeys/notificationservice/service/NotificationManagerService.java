package com.masterkeys.notificationservice.service;

import java.util.concurrent.CompletableFuture;

import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;

public interface NotificationManagerService {
    CompletableFuture<Void> sendNotification(SendNotificationRequest request);
}
