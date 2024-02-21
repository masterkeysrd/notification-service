package com.masterkeys.notificationservice.service.dto;

public record GetCategoryResponseItem(String id, String name) {
    public static GetCategoryResponseItem of(String id, String name) {
        return new GetCategoryResponseItem(id, name);
    }

    @Override
    public String toString() {
        return "GetCategoryResponseItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
