package com.diplomna.traders.dtos;

public class SubCategoryDTO {
    private String name;
    private String mainCategory;
    private String unit;

    public SubCategoryDTO(String name, String mainCategory, String unit) {
        this.name = name;
        this.mainCategory = mainCategory;
        this.unit = unit;
    }

    public SubCategoryDTO() {
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
