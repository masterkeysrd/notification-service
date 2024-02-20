package com.masterkeys.notificationservice.service.impl;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.masterkeys.notificationservice.model.NotificationRecord;
import com.masterkeys.notificationservice.repositories.NotificationRecordRepository;
import com.masterkeys.notificationservice.service.NotificationRecorderService;
import com.masterkeys.notificationservice.service.dto.GetHistoryResponseItem;
import com.masterkeys.notificationservice.service.dto.RecordNotificationRequest;

@Service
public class NotificationRecorderServiceImpl implements NotificationRecorderService {

    final private Logger logger = LoggerFactory.getLogger(NotificationRecorderServiceImpl.class);

    final private NotificationRecordRepository notificationRecordRepository;

    public NotificationRecorderServiceImpl(NotificationRecordRepository notificationRecordRepository) {
        this.notificationRecordRepository = notificationRecordRepository;
    }

    @Async
    public CompletableFuture<Void> record(RecordNotificationRequest request) {
        logger.debug("Recording notification: {}", request);

        NotificationRecord record = request.toNotificationRecord();

        if (record == null) {
            logger.error("Failed to record notification: {}", request);
            return CompletableFuture.completedFuture(null);
        }

        notificationRecordRepository.save(record);

        return CompletableFuture.completedFuture(null);
    }

    public Page<GetHistoryResponseItem> getHistory(Pageable pageable) {
        logger.debug("Getting notification history");

        if (pageable == null) {
            pageable = Pageable.ofSize(10);
        }

        return notificationRecordRepository.findAll(pageable).map(GetHistoryResponseItem::of);
    }
}
