package com.diplomna.traders.dtos;

public class ItemDTO {

    private String name;
    private String description;
    private double basePricePerUnit;
    private Long unit;

    public ItemDTO(String name, String description, double basePricePerUnit, Long unit) {
        this.name = name;
        this.description = description;
        this.basePricePerUnit = basePricePerUnit;
        this.unit = unit;
    }

    public ItemDTO() { }

    public String getName() {
        return name;
    }

    public double getBasePricePerUnit() {
        return basePricePerUnit;
    }

    public Long getUnit() {
        return unit;
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

    public void setUnit(Long unit) {
        this.unit = unit;
    }
}
