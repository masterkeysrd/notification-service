package com.masterkeys.notificationservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.repositories.UserRepository;
import com.masterkeys.notificationservice.service.UserService;
import com.masterkeys.notificationservice.service.dto.GetSubscribedUsersResponse;
import com.masterkeys.notificationservice.service.dto.GetSubscribedUsersResponseItem;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetSubscribedUsersResponse getSubscribedUsersByTopic(String topic) {
        logger.debug("Getting subscribed users by topic {}", topic);
        var subscribedUsers = userRepository.findBySubscriptions(topic).stream()
                .map(user -> GetSubscribedUsersResponseItem.of(user)).toList();

        return GetSubscribedUsersResponse.of(subscribedUsers);

    }
}
