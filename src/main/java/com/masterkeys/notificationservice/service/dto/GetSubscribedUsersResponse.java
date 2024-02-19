package com.masterkeys.notificationservice.service.dto;

import java.util.List;

public class GetSubscribedUsersResponse {
    private List<GetSubscribedUsersResponseItem> users;

    public GetSubscribedUsersResponse(List<GetSubscribedUsersResponseItem> users) {
        this.users = users;
    }

    public List<GetSubscribedUsersResponseItem> getUsers() {
        return users;
    }

    public void setUsers(List<GetSubscribedUsersResponseItem> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "GetSubscribedUsersResponse [users=" + users + "]";
    }
}
