package com.masterkeys.notificationservice.service;

import java.util.List;

import com.masterkeys.notificationservice.service.dto.GetCategoryResponseItem;

public interface CategoryService {
    List<GetCategoryResponseItem> getAll();
}
