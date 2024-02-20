package com.masterkeys.notificationservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.masterkeys.notificationservice.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String>{
}
