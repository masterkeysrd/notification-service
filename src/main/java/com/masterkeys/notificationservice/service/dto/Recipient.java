package com.masterkeys.notificationservice.service.dto;

import java.util.UUID;

public record Recipient(UUID id, String phoneNumber, String email, String deviceToken) {
    public static Recipient from(GetSubscribedUsersResponseItem user) {
        return new Recipient(user.getId(), user.getPhoneNumber(), user.getEmail(), user.getDeviceToken());
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