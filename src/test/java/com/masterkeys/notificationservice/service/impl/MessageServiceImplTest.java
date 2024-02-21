package com.masterkeys.notificationservice.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import com.masterkeys.notificationservice.service.NotificationManagerService;
import com.masterkeys.notificationservice.service.dto.SendMessageRequest;

public class MessageServiceImplTest {
    private MessageServiceImpl messageService;
    private NotificationManagerService notificationManagerService;

    @BeforeEach
    public void setUp() {
        notificationManagerService = Mockito.mock(NotificationManagerService.class);
        messageService = new MessageServiceImpl(notificationManagerService);
    }

    @Test
    public void testSendSuccess() {
        // Arrange
        var request = SendMessageRequest.of("Test message", "Test category");

        // Act
        var result = messageService.send(request);

        // Assert
        assert(result.getMessage().equals("Message started processing"));
    }
}
