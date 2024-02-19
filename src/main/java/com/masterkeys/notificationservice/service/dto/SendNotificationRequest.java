package com.masterkeys.notificationservice.service.dto;

// public class SendNotificationRequest {
//     String message;
//     String category;

//     public SendNotificationRequest() {
//     }

//     public SendNotificationRequest(String message, String category) {
//         this.message = message;
//         this.category = category;
//     }

//     public String getMessage() {
//         return message;
//     }

//     public String getCategory() {
//         return category;
//     }

//     public void setMessage(String message) {
//         this.message = message;
//     }

//     public void setCategory(String category) {
//         this.category = category;
//     }

//     @Override
//     public String toString() {
//         return "SendNotificationRequest{" +
//                 "message='" + message + '\'' +
//                 ", category='" + category + '\'' +
//                 '}';
//     }
// }

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
