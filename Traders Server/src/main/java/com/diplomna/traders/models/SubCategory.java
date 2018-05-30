package com.diplomna.traders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String unit;
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategory",fetch = FetchType.EAGER)
    private List<Item> items = new ArrayList<>();

    public SubCategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public SubCategory() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
