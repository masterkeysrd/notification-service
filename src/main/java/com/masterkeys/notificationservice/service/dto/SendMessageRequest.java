package com.masterkeys.notificationservice.service.dto;

public class SendMessageRequest {
    String category;
    String message;

    public SendMessageRequest() {
    }

    public SendMessageRequest(String category, String message) {
        this.category = category;
        this.message = message;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SendMessageRequest{" +
                "category='" + category + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
