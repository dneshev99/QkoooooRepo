package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.CategoryDTO;
import com.diplomna.traders.dtos.SubCategoryDTO;
import com.diplomna.traders.exceptions.CategoryNotFoundException;
import com.diplomna.traders.models.Category;
import com.diplomna.traders.models.SubCategory;
import com.diplomna.traders.repository.CategoryRepository;
import com.diplomna.traders.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubCategoryHandler {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Long crateSubCategories(SubCategoryDTO subCategoryDTO) throws CategoryNotFoundException {
        Long result = null;

        if (subCategoryDTO != null) {

            SubCategory newEntry = new SubCategory();

            newEntry.setName(subCategoryDTO.getName());

            Category category = categoryRepository.findByName(subCategoryDTO.getMainCategory());

            if (category == null)
                throw new CategoryNotFoundException("Invalid category");

            newEntry.setCategory(category);
            newEntry.setUnit(subCategoryDTO.getUnit());

        }


        return result;
}

    public List<SubCategory> getAllSubCategories() {
        return (List<SubCategory>) subCategoryRepository.findAll();
    }
}
