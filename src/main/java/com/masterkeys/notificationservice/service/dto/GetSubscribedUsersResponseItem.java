package com.masterkeys.notificationservice.service.dto;

import java.util.List;
import java.util.UUID;

import com.masterkeys.notificationservice.model.Channel;

public class GetSubscribedUsersResponseItem {
    private UUID id;
    private String phoneNumber;
    private String email;
    private String deviceToken;
    private List<Channel> channels;

    public GetSubscribedUsersResponseItem(UUID id, String phoneNumber, String email, String deviceToken,
            List<Channel> channels) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.deviceToken = deviceToken;
        this.channels = channels;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
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
