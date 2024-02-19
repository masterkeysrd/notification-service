package com.masterkeys.notificationservice.service.dto;

import java.util.List;

public record GetSubscribedUsersResponse(List<GetSubscribedUsersResponseItem> users) {
    public GetSubscribedUsersResponse {
        if (users == null) {
            throw new IllegalArgumentException("Users cannot be null");
        }
    }

    public static GetSubscribedUsersResponse of(List<GetSubscribedUsersResponseItem> users) {
        return new GetSubscribedUsersResponse(users);
    }

    @Override
    public String toString() {
        return "GetSubscribedUsersResponse [users=" + users + "]";
    }
}