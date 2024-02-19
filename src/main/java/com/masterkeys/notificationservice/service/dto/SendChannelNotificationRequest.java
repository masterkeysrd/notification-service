package com.masterkeys.notificationservice.service.dto;

public record SendChannelNotificationRequest(String message, String channel, Recipient recipient) {
    public SendChannelNotificationRequest {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        if (channel == null || channel.isBlank()) {
            throw new IllegalArgumentException("Channel cannot be null or empty");
        }
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient cannot be null");
        }
    }

    @Override
    public String toString() {
        return "SendChannelNotificationRequest{" +
                "message='" + message + '\'' +
                ", channel='" + channel + '\'' +
                ", recipient=" + recipient +
                '}';
    }
}
