package com.masterkeys.notificationservice.service.dto;

import java.util.List;
import java.util.UUID;

import com.masterkeys.notificationservice.model.Channel;

public record GetSubscribedUsersResponseItem(UUID id, String phoneNumber, String email, String deviceToken,
        List<Channel> channels) {
    public GetSubscribedUsersResponseItem {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (channels == null) {
            throw new IllegalArgumentException("Channels cannot be null");
        }
    }

    public static GetSubscribedUsersResponseItem of(UUID id, String phoneNumber, String email, String deviceToken,
            List<Channel> channels) {
        return new GetSubscribedUsersResponseItem(id, phoneNumber, email, deviceToken, channels);
    }

    @Override
    public String toString() {
        return "GetSubscribedUsersResponseItem{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", deviceToken='" + deviceToken + '\'' +
                ", channels=" + channels +
                '}';
    }
}