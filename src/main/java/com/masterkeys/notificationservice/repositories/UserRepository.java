package com.masterkeys.notificationservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.masterkeys.notificationservice.model.User;


public interface UserRepository extends MongoRepository<User, String> {
    List<User> findBySubscriptions(String subscription);
}
