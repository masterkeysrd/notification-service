package com.masterkeys.notificationservice.service.dto;

public record SendMessageRequest(String category, String message) {
    public SendMessageRequest {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }

        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
    }

    public static SendMessageRequest of(String category, String message) {
        return new SendMessageRequest(category, message);
    }

    @Override
    public String toString() {
        return "SendMessageRequest{" +
                "category='" + category + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
