package com.masterkeys.notificationservice.service.dto;

import java.util.UUID;

public record Recipient(UUID id, String phoneNumber, String email, String deviceToken) {
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