package com.masterkeys.notificationservice.service.dto;

public record SendNotificationRequest(Recipient recipient, String message) {
    public SendNotificationRequest {
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient cannot be null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
    }

    public static SendNotificationRequest of(Recipient recipient, String message) {
        return new SendNotificationRequest(recipient, message);
    }

    @Override
    public String toString() {
        return "SendNotificationRequest{" +
                "recipient=" + recipient +
                ", message='" + message + '\'' +
                '}';
    }
}
