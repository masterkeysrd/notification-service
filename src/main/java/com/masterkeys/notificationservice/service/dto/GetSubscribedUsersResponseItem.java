package com.masterkeys.notificationservice.service.dto;

import java.util.List;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.model.User;

public record GetSubscribedUsersResponseItem(String id, String phoneNumber, String email, String deviceToken,
        List<Channel> channels) {
    public GetSubscribedUsersResponseItem {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (channels == null) {
            throw new IllegalArgumentException("Channels cannot be null");
        }
    }

    public static GetSubscribedUsersResponseItem of(User user) {
        return new GetSubscribedUsersResponseItem(user.getId(), user.getPhoneNumber(), user.getEmail(),
                user.getDeviceToken(), user.getChannels());
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