package com.masterkeys.notificationservice.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.masterkeys.notificationservice.model.Category;
import com.masterkeys.notificationservice.repositories.CategoryRepository;
import com.masterkeys.notificationservice.repositories.NotificationRecordRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final CategoryRepository categoryRepository;
    private final NotificationRecordRepository notificationRecordRepository;

    public DatabaseInitializer(CategoryRepository categoryRepository, NotificationRecordRepository notificationRecordRepository) {
        this.categoryRepository = categoryRepository;
        this.notificationRecordRepository = notificationRecordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Initializing database");

        logger.info("Deleting all notification records");
        notificationRecordRepository.deleteAll();

        logger.info("Deleting all categories");
        categoryRepository.deleteAll();

        logger.info("Inserting categories");
        var sports = categoryRepository.save(new Category("Sports"));
        var politics = categoryRepository.save(new Category("Politics"));
        var technology = categoryRepository.save(new Category("Technology"));

        logger.info("Database initialized");
    }
}
