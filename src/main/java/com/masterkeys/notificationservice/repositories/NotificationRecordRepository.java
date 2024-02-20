package com.masterkeys.notificationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.masterkeys.notificationservice.model.NotificationRecord;

@Repository
public interface NotificationRecordRepository extends MongoRepository<NotificationRecord, String> {
    
}
