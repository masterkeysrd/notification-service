package com.masterkeys.notificationservice.service;

import java.util.concurrent.CompletableFuture;

import com.masterkeys.notificationservice.service.dto.FanOutNotificationRequest;

public interface NotificationManagerService {
    CompletableFuture<Void> fanOut(FanOutNotificationRequest request);
}
