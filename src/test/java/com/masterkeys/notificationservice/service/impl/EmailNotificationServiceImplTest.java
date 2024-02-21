package com.masterkeys.notificationservice.service.impl;

import org.junit.jupiter.api.Test;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.service.dto.Recipient;
import com.masterkeys.notificationservice.service.dto.SendNotificationRequest;

public class EmailNotificationServiceImplTest {
    @Test
    public void testSend() {
        // Arrange
        var recipient = Recipient.of("user1", "1234567890", "user@mail.com", "deviceToken");
        var request = SendNotificationRequest.of(recipient, "Test message");

        EmailNotificationServiceImpl emailNotificationService = new EmailNotificationServiceImpl();
        // Act

        var result = emailNotificationService.send(request);
        // Assert

        assert(result.notificationId() != null);
        assert(result.userId().equals(recipient.id()));
        assert(result.channel().equals(Channel.EMAIL));
        assert(result.destination().equals(recipient.email()));
        assert(result.message().equals(request.message()));
        assert(result.timestamp() > 0);
        assert(result.status().equals("SENT"));
    }
}
