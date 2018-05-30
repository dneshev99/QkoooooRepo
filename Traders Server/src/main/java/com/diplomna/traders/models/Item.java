package com.diplomna.traders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_base_price_per_unit")
    private double basePricePerUnit;

    @Column(name = "item_description")
    @Size(max = 5000)
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subcategory_id",nullable = false)
    private SubCategory subCategory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Item(String name, double basePricePerUnit, String description, SubCategory subCategory, User user) {
        this.name = name;
        this.basePricePerUnit = basePricePerUnit;
        this.description = description;
        this.subCategory = subCategory;
        this.user = user;
    }

    public Item() {}


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePricePerUnit() {
        return basePricePerUnit;
    }

    public void setBasePricePerUnit(double basePricePerUnit) {
        this.basePricePerUnit = basePricePerUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public long getId() {
        return id;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
