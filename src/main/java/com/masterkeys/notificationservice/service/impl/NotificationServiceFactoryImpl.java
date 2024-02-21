package com.masterkeys.notificationservice.service.impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.service.EmailNotificationService;
import com.masterkeys.notificationservice.service.NotificationService;
import com.masterkeys.notificationservice.service.NotificationServiceFactory;
import com.masterkeys.notificationservice.service.PushNotificationService;
import com.masterkeys.notificationservice.service.SMSNotificationService;

@Service
public class NotificationServiceFactoryImpl implements NotificationServiceFactory {

    private final Map<Channel, NotificationService> notificationServices;

    public NotificationServiceFactoryImpl(
            EmailNotificationService emailNotificationService,
            PushNotificationService pushNotificationService,
            SMSNotificationService smsNotificationService) {

        notificationServices = Map.of(
                Channel.EMAIL, emailNotificationService,
                Channel.PUSH, pushNotificationService,
                Channel.SMS, smsNotificationService);
    }

    public Optional<NotificationService> get(Channel channel) {
        return Optional.ofNullable(notificationServices.get(channel));
    }
}
