package com.masterkeys.notificationservice.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masterkeys.notificationservice.service.NotificationRecorderService;
import com.masterkeys.notificationservice.service.dto.GetHistoryResponseItem;

@RestController
@RequestMapping("/api/v1/notification-history")
public class NotificationHistoryResource {

    private final Logger logger = LoggerFactory.getLogger(NotificationHistoryResource.class);

    private final NotificationRecorderService notificationRecorderService;

    public NotificationHistoryResource(NotificationRecorderService notificationRecorderService) {
        this.notificationRecorderService = notificationRecorderService;
    }

    @GetMapping("")
    public Page<GetHistoryResponseItem> getNotificationHistory(Pageable pageable) {
        logger.debug("Getting notification history");

        return notificationRecorderService.getHistory(pageable);
    }
}
