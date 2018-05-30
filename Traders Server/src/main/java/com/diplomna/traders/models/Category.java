package com.diplomna.traders.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "category_name")
    @NotNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category",fetch = FetchType.EAGER)
    private List<SubCategory> subCategories = new ArrayList<>();

    public Category(String name, int level) {
        this.name = name;
    }

    public Category() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
}
