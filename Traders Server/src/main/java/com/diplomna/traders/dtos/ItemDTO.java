package com.diplomna.traders.dtos;

public class ItemDTO {

    private String name;
    private String description;
    private double basePricePerUnit;
    private String user;
    private String category;

    public ItemDTO() { }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
