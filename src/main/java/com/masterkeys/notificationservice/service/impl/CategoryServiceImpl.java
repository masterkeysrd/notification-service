package com.masterkeys.notificationservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.masterkeys.notificationservice.repositories.CategoryRepository;
import com.masterkeys.notificationservice.service.CategoryService;
import com.masterkeys.notificationservice.service.dto.GetCategoryResponseItem;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoriesRepository;

    public CategoryServiceImpl(CategoryRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public Optional<GetCategoryResponseItem> getById(String id) {
        logger.debug("Getting category by id {}", id);

        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        return categoriesRepository.findById(id)
                .map(category -> GetCategoryResponseItem.of(category.getId(), category.getName()));
    }

    public List<GetCategoryResponseItem> getAll() {
        logger.debug("Getting all categories");

        return categoriesRepository.findAll().stream()
                .map(category -> GetCategoryResponseItem.of(category.getId(), category.getName()))
                .toList();
    }

}
