package com.masterkeys.notificationservice.service.dto;

public record SendNotificationRequest(String message, String category) {
    public SendNotificationRequest {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }

        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
    }

    public static SendNotificationRequest of(String message, String category) {
        return new SendNotificationRequest(message, category);
    }

    @Override
    public String toString() {
        return "SendNotificationRequest{" +
                "message='" + message + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
