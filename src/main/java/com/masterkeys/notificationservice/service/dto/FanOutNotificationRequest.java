package com.masterkeys.notificationservice.service.dto;

public record FanOutNotificationRequest(String message, String category) {
    public FanOutNotificationRequest {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }

        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
    }

    public static FanOutNotificationRequest of(String message, String category) {
        return new FanOutNotificationRequest(message, category);
    }

    @Override
    public String toString() {
        return "FanOutNotificationRequest{" +
                "message='" + message + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
