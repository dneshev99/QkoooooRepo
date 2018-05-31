package com.diplomna.traders.controllers;

import com.diplomna.traders.dtos.ErrorDTO;
import com.diplomna.traders.dtos.ItemDTO;
import com.diplomna.traders.business.logic.ItemHandler;
import com.diplomna.traders.exceptions.AbstractRestException;
import com.diplomna.traders.exceptions.SubCategoryNotFoundException;
import com.diplomna.traders.exceptions.UserNotFoundException;
import com.diplomna.traders.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemHandler itemHandler;

    @RequestMapping(value = "/create",method = POST)
    public ResponseEntity createItem(@RequestBody ItemDTO itemDTO){

        try {
            itemHandler.createNewItem(itemDTO);
        } catch (AbstractRestException e) {
            ErrorDTO error = new ErrorDTO();
            error.setMessage(e.getMessage());

            return ResponseEntity.badRequest().body(error);
        }

        return ResponseEntity.ok(itemDTO);
    }
    
    @RequestMapping(value = "/getAll", method = GET)
    public ResponseEntity getAllItems(){
        List<ItemDTO> objects = itemHandler.getAllItems();
        
        return ResponseEntity.ok(objects);
    }

    @RequestMapping(value = "/getByUser/{username}",method = GET)
    public ResponseEntity getAllByUsername(@PathVariable String username) {
        List<Item> result;

        try {
            result = itemHandler.getItemsByUser(username);
        } catch (UserNotFoundException e) {
            ErrorDTO error = new ErrorDTO();
            error.setMessage(e.getMessage());

            return ResponseEntity.badRequest().body(error);
        }

        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/getBySubCategory/{subCategoryName}",method = GET)
    public ResponseEntity getAllBySubCategory(@PathVariable String subCategoryName) {
        List<Item> result;

        try {
            result = itemHandler.getAllBySubCategory(subCategoryName);
        } catch (SubCategoryNotFoundException e) {
            ErrorDTO error = new ErrorDTO();
            error.setMessage(e.getMessage());

            return ResponseEntity.badRequest().body(error);
        }

        return ResponseEntity.ok(result);
    }

}
