package com.diplomna.traders.dtos;

public class CategoryDTO {

    private String name;

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
