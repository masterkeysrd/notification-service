package com.masterkeys.notificationservice.service;

import com.masterkeys.notificationservice.service.dto.GetSubscribedUsersResponse;

public interface UserService {
    GetSubscribedUsersResponse getSubscribedUsersByTopic(String topic);
}
