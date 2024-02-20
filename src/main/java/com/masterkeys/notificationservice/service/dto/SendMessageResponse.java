package com.masterkeys.notificationservice.service.dto;

public class SendMessageResponse {
    private String message;

    public SendMessageResponse() {
    }

    public SendMessageResponse(String message) {
        this.message = message;
    }

    public static SendMessageResponse of(String message) {
        return new SendMessageResponse(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SendMessageResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
