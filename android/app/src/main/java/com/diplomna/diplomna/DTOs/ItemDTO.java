package com.diplomna.diplomna.DTOs;

import java.io.Serializable;

public class ItemDTO implements Serializable{
    private String name;
    private String description;
    private double basePricePerUnit;
    private String user;
    private String subCategory;
    private int quantity;

    public ItemDTO(String name, String description, double basePricePerUnit, String user, String subCategory, int quantity) {
        this.name = name;
        this.description = description;
        this.basePricePerUnit = basePricePerUnit;
        this.user = user;
        this.subCategory = subCategory;
        this.quantity = quantity;
    }

    public ItemDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBasePricePerUnit() {
        return basePricePerUnit;
    }

    public void setBasePricePerUnit(double basePricePerUnit) {
        this.basePricePerUnit = basePricePerUnit;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
