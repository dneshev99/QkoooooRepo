package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.CategoryDTO;
import com.diplomna.traders.models.Category;
import com.diplomna.traders.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryHandler {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Long> createNewCategory(List<CategoryDTO> categoryDTOs){

        List<Long> result = new ArrayList<>();

        if(categoryDTOs != null) {
            for (CategoryDTO categoryDTO : categoryDTOs) {
                Category category = new Category();
                category.setName(categoryDTO.getName());

                result.add(categoryRepository.save(category).getId());
            }
        }

        return result;
    }

    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

}
