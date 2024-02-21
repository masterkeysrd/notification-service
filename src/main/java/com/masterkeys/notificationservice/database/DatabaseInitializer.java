package com.masterkeys.notificationservice.database;

import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.masterkeys.notificationservice.model.Category;
import com.masterkeys.notificationservice.model.Channel;
import com.masterkeys.notificationservice.model.User;
import com.masterkeys.notificationservice.repositories.CategoryRepository;
import com.masterkeys.notificationservice.repositories.NotificationRecordRepository;
import com.masterkeys.notificationservice.repositories.UserRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final NotificationRecordRepository notificationRecordRepository;

    public DatabaseInitializer(UserRepository userRepository, CategoryRepository categoryRepository,
            NotificationRecordRepository notificationRecordRepository) {
        this.userRepository = userRepository;
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
        var finance = categoryRepository.save(new Category("Finance"));
        var movies = categoryRepository.save(new Category("Movies"));

        logger.info("Creating users subscribed to sports");
        // Create a range of numbers from 1 to 10
        IntStream.range(1, 11).mapToObj(i -> {
            var user = userRepository
                    .save(new User(null, "User " + i, "user" + i + "@example.com", "1234567890", "deviceToken " + i,
                            List.of(sports.getId()), List.of(Channel.PUSH)));
            logger.info("Created user {}", user);
            return user;
        }).toList();

        logger.info("Creating users subscribed to finance");
        IntStream.range(11, 21).mapToObj(i -> {
            var user = userRepository
                    .save(new User(null, "User " + i, "user" + i + "@example.com", "1234567890", "deviceToken " + i,
                            List.of(finance.getId()), List.of(Channel.EMAIL)));

            logger.info("Created user {}", user);
            return user;
        }).toList();

        logger.info("Creating users subscribed to movies");
        IntStream.range(21, 31).mapToObj(i -> {
            var user = userRepository
                    .save(new User(null, "User " + i, "user" + i + "@example.com", "1234567890", "deviceToken " + i,
                            List.of(movies.getId()), List.of(Channel.SMS)));
            logger.info("Created user {}", user);
            return user;
        }).toList();

        logger.info("Creating users subscribed to sports and finance");
        IntStream.range(31, 41).mapToObj(i -> {
            var user = userRepository.save(new User(null, "User " + i, "user" + i + "@example.com", "1234567890", "deviceToken " + i,
                    List.of(sports.getId(), finance.getId()), List.of(Channel.PUSH, Channel.EMAIL)));
            logger.info("Created user {}", user);
            return user;
        }).toList();

        logger.info("Creating users subscribed to sports and movies");
        IntStream.range(41, 51).mapToObj(i -> {
            var user = userRepository.save(new User(null, "User " + i, "user" + i + "@example.com", "1234567890", "deviceToken " + i,
                    List.of(sports.getId(), movies.getId()), List.of(Channel.PUSH, Channel.EMAIL, Channel.SMS)));
            logger.info("Created user {}", user);
            return user;
        }).toList();

        logger.info("Creating users subscribed to finance and movies");
        IntStream.range(51, 61).mapToObj(i -> {
            var user = userRepository.save(new User(null, "User " + i, "user" + i + "@example.com", "1234567890", "deviceToken " + i,
                    List.of(finance.getId(), movies.getId()), List.of()));
            logger.info("Created user {}", user);
            return user;
        }).toList();

        logger.info("Database initialized");
    }
}
