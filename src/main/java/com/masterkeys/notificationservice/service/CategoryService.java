package com.masterkeys.notificationservice.service;

import java.util.List;
import java.util.Optional;

import com.masterkeys.notificationservice.service.dto.GetCategoryResponseItem;

public interface CategoryService {
    Optional<GetCategoryResponseItem> getById(String id);
    List<GetCategoryResponseItem> getAll();
}
