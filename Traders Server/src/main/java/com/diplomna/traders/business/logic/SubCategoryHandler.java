package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.CategoryDTO;
import com.diplomna.traders.dtos.SubCategoryDTO;
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

    public List<Long> crateSubCategories(List<SubCategoryDTO> dtos) {
        List<Long> result = new ArrayList<>();

        if(dtos != null) {
            for (SubCategoryDTO subCategoryDTO : dtos) {
                SubCategory newEntry = new SubCategory();

                newEntry.setName(subCategoryDTO.getName());

                Category category = categoryRepository.findByName(subCategoryDTO.getMainCategory());

                newEntry.setCategory(category);

                if (category != null) {
                    result.add(subCategoryRepository.save(newEntry).getId());
                }
            }
        }

        return result;
    }

    public List<SubCategory> getAllSubCategories() {
        return (List<SubCategory>) subCategoryRepository.findAll();
    }
}
