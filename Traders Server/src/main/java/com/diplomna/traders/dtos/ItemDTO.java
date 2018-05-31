package com.diplomna.traders.dtos;

public class ItemDTO {

    private String name;
    private String description;
    private double basePricePerUnit;
    private String user;
    private String subCategory;

    public ItemDTO() { }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public double getBasePricePerUnit() {
        return basePricePerUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBasePricePerUnit(double basePricePerUnit) {
        this.basePricePerUnit = basePricePerUnit;
    }

}
