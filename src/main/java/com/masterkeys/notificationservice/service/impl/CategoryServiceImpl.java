package com.masterkeys.notificationservice.service.impl;

import java.util.List;

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

    public List<GetCategoryResponseItem> getAll() {
        logger.debug("Getting all categories");

        return categoriesRepository.findAll().stream()
                .map(category -> GetCategoryResponseItem.of(category.getId(), category.getName()))
                .toList();
    }

}
