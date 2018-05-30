package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.CategoryDTO;
import com.diplomna.traders.business.logic.CategoryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    @Autowired
    private CategoryHandler catHandler;

    @RequestMapping(value = "/create",method = POST)
    public ResponseEntity createCategory(@RequestBody List<CategoryDTO> categoryDTO){

        catHandler.createNewCategory(categoryDTO);

        return ResponseEntity.ok(categoryDTO);
    }

    @RequestMapping(value = "/",method = GET)
    public ResponseEntity getAllCategories() {
        return ResponseEntity.ok(catHandler.getAll());
    }

}
