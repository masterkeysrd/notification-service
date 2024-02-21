package com.masterkeys.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("notificationrecord")
public class NotificationRecord {

    @Id
    private String id;
    private String notificationId;
    private String userId;
    private Channel channel;
    private String category;
    private String destination;
    private String message;
    private String status;
    private int timestamp;

    public NotificationRecord() {
    }

    public NotificationRecord(String id, String notificationId, String userId, Channel channel, String category,
            String destination, String message, String status, int timestamp) {
        this.id = id;
        this.notificationId = notificationId;
        this.userId = userId;
        this.channel = channel;
        this.category = category;
        this.destination = destination;
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public static NotificationRecord of(String notificationId, String userId, Channel channel, String category,
            String destination, String message, String status, int timestamp) {
        return new NotificationRecord(null, notificationId, userId, channel, category, destination, message, status,
                timestamp);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "NotificationRecord{" +
                "id='" + id + '\'' +
                ", notificationId='" + notificationId + '\'' +
                ", userId='" + userId + '\'' +
                ", channel='" + channel + '\'' +
                ", category='" + category + '\'' +
                ", destination='" + destination + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}
