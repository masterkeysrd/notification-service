package com.masterkeys.notificationservice.service;

import java.util.concurrent.CompletableFuture;

import com.masterkeys.notificationservice.service.dto.RecordNotificationRequest;

public interface NotificationRecorderService {
    CompletableFuture<Void> record(RecordNotificationRequest request);   
}
