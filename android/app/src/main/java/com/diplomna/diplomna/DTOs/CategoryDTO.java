package com.diplomna.diplomna.DTOs;

public class CategoryDTO {
    private Long id;
    private String name;

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}
