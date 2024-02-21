package com.masterkeys.notificationservice.service.impl;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.masterkeys.notificationservice.model.Category;
import com.masterkeys.notificationservice.repositories.CategoryRepository;
import com.masterkeys.notificationservice.service.CategoryService;

public class CategoryServiceImplTest {
    private CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);

    @Test
    public void testGetAllCategories() {
        // Arrange
        var mockCategories = new ArrayList<Category>();
        mockCategories.add(new Category("abc1", "Test Category 1"));
        mockCategories.add(new Category("abc2", "Test Category 2"));

        Mockito.when(categoryRepository.findAll()).thenReturn(mockCategories);
        CategoryService categoryService = new CategoryServiceImpl(categoryRepository);

        // Act
        var result = categoryService.getAll();

        // Assert
        Mockito.verify(categoryRepository, Mockito.times(1)).findAll();
        assert(result.size() == 2);
        for (int i = 0; i < result.size(); i++) {
            assert(result.get(i).id().equals(mockCategories.get(i).getId()));
            assert(result.get(i).name().equals(mockCategories.get(i).getName()));
        }
    }
}
