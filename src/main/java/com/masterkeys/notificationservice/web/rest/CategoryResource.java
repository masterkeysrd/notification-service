package com.masterkeys.notificationservice.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masterkeys.notificationservice.service.CategoryService;
import com.masterkeys.notificationservice.service.dto.GetCategoryResponseItem;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryResource {

    private final Logger logger = LoggerFactory.getLogger(CategoryResource.class);

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<GetCategoryResponseItem> getAll() {
        logger.debug("REST request to get all categories");

        return categoryService.getAll();
    }    
}
