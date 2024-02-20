package com.masterkeys.notificationservice.service.dto;

public class GetCategoryResponseItem {
    private String id;
    private String name;

    public GetCategoryResponseItem() {
    }

    public GetCategoryResponseItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static GetCategoryResponseItem of(String id, String name) {
        return new GetCategoryResponseItem(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GetCategoryResponseItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
