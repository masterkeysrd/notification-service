package com.masterkeys.notificationservice.service.dto;

import java.util.UUID;

import com.masterkeys.notificationservice.model.Channel;

public record SendNotificationResponse(UUID notificationId, String userId, Channel channel, String destination,
        String message, int timestamp, String status) {
    public SendNotificationResponse {
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
    }

    public static SendNotificationResponse of(UUID notificationId, String userId, Channel channel, String destination,
            String message, int timestamp, String status) {
        return new SendNotificationResponse(notificationId, userId, channel, destination, message, timestamp, status);
    }

    @Override
    public String toString() {
        return "SendNotificationResponse{" + "notificationId=" + notificationId + ", userId=" + userId + ", channel="
                + channel + ", destination='" + destination + '\'' + ", message='" + message + '\'' + ", timestamp="
                + timestamp + '\'' + ", status='" + status + '\'' + '}';
    }
}
