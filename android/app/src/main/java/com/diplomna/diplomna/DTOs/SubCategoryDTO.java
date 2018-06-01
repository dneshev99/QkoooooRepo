package com.diplomna.diplomna.DTOs;

public class SubCategoryDTO {
    private String name;
    private String unit;

    public SubCategoryDTO(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public SubCategoryDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
