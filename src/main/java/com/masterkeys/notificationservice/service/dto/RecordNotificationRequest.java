package com.masterkeys.notificationservice.service.dto;

import com.masterkeys.notificationservice.model.Category;
import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.model.NotificationRecord;

public record RecordNotificationRequest(String notificationId, String userId, String categoryId, String categoryName,
        Channel channel,
        String destination,
        String message, String status, int timestamp) {
    public RecordNotificationRequest {
        if (notificationId == null) {
            throw new IllegalArgumentException("notificationId must not be null");
        }
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        if (categoryId == null) {
            throw new IllegalArgumentException("categoryId must not be null");
        }
        if (channel == null) {
            throw new IllegalArgumentException("channel must not be null");
        }
        if (destination == null) {
            throw new IllegalArgumentException("destination must not be null");
        }
        if (message == null) {
            throw new IllegalArgumentException("message must not be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("status must not be null");
        }
        if (timestamp < 0) {
            throw new IllegalArgumentException("timestamp must be greater than or equal to 0");
        }

    }

    public static RecordNotificationRequest of(String notificationId, String userId, String categoryId,
            String categoryName, Channel channel,
            String destination, String message, String status, int timestamp) {
        return new RecordNotificationRequest(notificationId, userId, categoryId, categoryName, channel, destination,
                message, status, timestamp);
    }

    public NotificationRecord toNotificationRecord() {
        return NotificationRecord.of(notificationId, userId, channel, new Category(categoryId, categoryName),
                destination, message, status,
                timestamp);
    }

    @Override
    public String toString() {
        return "RecordNotificationRequest{" +
                "notificationId=" + notificationId +
                ", userId=" + userId +
                ", channel=" + channel +
                ", destination='" + destination + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp + '\'' +
                '}';
    }
}