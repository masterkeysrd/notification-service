package com.masterkeys.notificationservice.service.dto;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.model.NotificationRecord;

public record GetHistoryResponseItem(String id, String notificationId, String userId, Channel channel, String categoryId, String categoryName, String destination,
        String message, String status, int timestamp) {
    public GetHistoryResponseItem {
    }

    public static GetHistoryResponseItem of(NotificationRecord record) {
        return new GetHistoryResponseItem(
                record.getId(),
                record.getNotificationId(),
                record.getUserId(),
                record.getChannel(),
                record.getCategoryId(),
                record.getCategoryName(),
                record.getDestination(),
                record.getMessage(),
                record.getStatus(),
                record.getTimestamp());
    }
}
