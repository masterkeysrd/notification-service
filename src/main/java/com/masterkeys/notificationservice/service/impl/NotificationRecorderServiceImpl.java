package com.masterkeys.notificationservice.service.impl;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.service.NotificationRecorderService;
import com.masterkeys.notificationservice.service.dto.RecordNotificationRequest;

@Service
public class NotificationRecorderServiceImpl implements NotificationRecorderService {

    final private Logger logger = LoggerFactory.getLogger(NotificationRecorderServiceImpl.class);

    @Async
    public CompletableFuture<Void> record(RecordNotificationRequest request) {
        logger.debug("Recording notification: {}", request);

        return CompletableFuture.completedFuture(null);
    }
}
