package com.masterkeys.notificationservice.service;

import java.util.Optional;

import com.masterkeys.notificationservice.model.Channel;

public interface NotificationServiceFactory {
    Optional<NotificationService> get(Channel channel);
}
