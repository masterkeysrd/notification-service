package com.masterkeys.notificationservice.service.dto;

public record Recipient(String id, String phoneNumber, String email, String deviceToken) {
    public static Recipient of(String id, String phoneNumber, String email, String deviceToken) {
        return new Recipient(id, phoneNumber, email, deviceToken);
    }
    
    public static Recipient of(GetSubscribedUsersResponseItem user) {
        return new Recipient(user.id(), user.phoneNumber(), user.email(), user.deviceToken());
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", deviceToken='" + deviceToken + '\'' +
                '}';
    }
}