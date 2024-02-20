package com.masterkeys.notificationservice.service.dto;

import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.model.NotificationRecord;

public record GetHistoryResponseItem(String id, String userId, Channel channel, String category, String destination,
        String message, String status, int timestamp) {
    public GetHistoryResponseItem {
    }

    public static GetHistoryResponseItem of(NotificationRecord record) {
        return new GetHistoryResponseItem(
                record.getId(),
                record.getUserId(),
                record.getChannel(),
                record.getCategory(),
                record.getDestination(),
                record.getMessage(),
                record.getStatus(),
                record.getTimestamp());
    }
}
