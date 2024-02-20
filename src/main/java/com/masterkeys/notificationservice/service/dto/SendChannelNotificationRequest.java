package com.masterkeys.notificationservice.service.dto;

import com.masterkeys.notificationservice.model.Channel;

public record SendChannelNotificationRequest(String message, Channel channel, Recipient recipient) {
    public SendChannelNotificationRequest {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        if (channel == null) {
            throw new IllegalArgumentException("Channel cannot be null or empty");
        }
        if (recipient == null) {
            throw new IllegalArgumentException("Recipient cannot be null");
        }
    }

    public static SendChannelNotificationRequest from(FanOutNotificationRequest request, Channel channel,
            Recipient recipient) {
        return new SendChannelNotificationRequest(request.message(), channel, recipient);
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
