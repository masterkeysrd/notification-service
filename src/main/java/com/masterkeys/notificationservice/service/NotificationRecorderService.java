package com.masterkeys.notificationservice.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.masterkeys.notificationservice.service.dto.GetHistoryResponseItem;
import com.masterkeys.notificationservice.service.dto.RecordNotificationRequest;

public interface NotificationRecorderService {
    CompletableFuture<Void> record(RecordNotificationRequest request);   
    Page<GetHistoryResponseItem> getHistory(Pageable pageable);
}
