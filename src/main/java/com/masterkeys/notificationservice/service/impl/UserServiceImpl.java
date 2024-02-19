package com.masterkeys.notificationservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.service.UserService;
import com.masterkeys.notificationservice.service.dto.GetSubscribedUsersResponse;
import com.masterkeys.notificationservice.service.dto.GetSubscribedUsersResponseItem;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final List<GetSubscribedUsersResponseItem> users;

    public UserServiceImpl() {
        users = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            users.add(new GetSubscribedUsersResponseItem(UUID.randomUUID(), "+123456789" + i,
                    "user" + i + "@example.com", "deviceToken" + i, List.of("SMS", "EMAIL", "PUSH")));
        }
    }

    @Override
    public GetSubscribedUsersResponse getSubscribedUsersByTopic(String topic) {
        logger.debug("Getting subscribed users by topic {}", topic);
        return new GetSubscribedUsersResponse(users);
    }
}
