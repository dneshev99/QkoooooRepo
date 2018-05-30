package com.diplomna.traders.dtos;

public class SubCategoryDTO {
    private String name;
    private String mainCategory;

    public SubCategoryDTO(String name, String mainCategory) {
        this.name = name;
        this.mainCategory = mainCategory;
    }

    public SubCategoryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }
}
