package com.diplomna.traders.controllers;

import com.diplomna.traders.business.logic.SubCategoryHandler;
import com.diplomna.traders.dtos.ErrorDTO;
import com.diplomna.traders.dtos.SubCategoryDTO;
import com.diplomna.traders.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SubCategoryController {
    @Autowired
    private SubCategoryHandler subCategoryHandler;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity getAllSubCategories() {
        return ResponseEntity.ok(subCategoryHandler.getAllSubCategories());
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity createSubCategories(@RequestBody SubCategoryDTO subCategoryDTO) {
        try {
            return ResponseEntity.ok(subCategoryHandler.crateSubCategories(subCategoryDTO));
        } catch (CategoryNotFoundException e) {
            ErrorDTO error = new ErrorDTO();
            error.setMessage(e.getMessage());

            return ResponseEntity.badRequest().body(error);
        }
    }

}
