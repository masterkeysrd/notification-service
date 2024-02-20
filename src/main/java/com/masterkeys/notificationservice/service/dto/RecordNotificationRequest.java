package com.masterkeys.notificationservice.service.dto;

import java.util.UUID;

import com.masterkeys.notificationservice.model.Channel;

public record RecordNotificationRequest(UUID notificationId, UUID userId, Channel channel, String destination,
        String message, String status, int timestamp) {
    public RecordNotificationRequest {
        if (notificationId == null) {
            throw new IllegalArgumentException("notificationId must not be null");
        }
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
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
            throw new IllegalArgumentException("timestamp must not be negative");
        }
    }

    public static RecordNotificationRequest of(UUID notificationId, UUID userId, Channel channel, String destination,
            String message, String status, int timestamp) {
        return new RecordNotificationRequest(notificationId, userId, channel, destination, message, status, timestamp);
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