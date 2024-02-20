package com.masterkeys.notificationservice.service;

import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;
import com.masterkeys.notificationservice.service.dto.SendNotificationResponse;

public interface NotificationService {
    /**
     * Send a notification to a recipient
     * @param request the request to send a notification
     * @return the response of the notification
     */
    SendNotificationResponse send(SendNotificationRequest request);
}
