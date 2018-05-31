package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.ItemDTO;
import com.diplomna.traders.exceptions.SubCategoryNotFoundException;
import com.diplomna.traders.exceptions.UserNotFoundException;
import com.diplomna.traders.models.Item;
import com.diplomna.traders.models.SubCategory;
import com.diplomna.traders.models.User;
import com.diplomna.traders.repository.ItemRepository;
import com.diplomna.traders.repository.SubCategoryRepository;
import com.diplomna.traders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemHandler {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public Long createNewItem(ItemDTO newItem) throws UserNotFoundException, SubCategoryNotFoundException {

        Long result = null;

        if(newItem != null) {

                User user = userRepository.findByUsername(newItem.getUser());
                SubCategory subCategory = subCategoryRepository.findByName(newItem.getSubCategory());

                if (user == null)
                    throw new UserNotFoundException("Invalid user");


                if (subCategory == null) {
                    throw new SubCategoryNotFoundException("Invalid SubCategory");
                }

                Item item = new Item();
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                item.setBasePricePerUnit(newItem.getBasePricePerUnit());
                item.setUser(user);
                item.setSubCategory(subCategory);

                result = itemRepository.save(item).getId();

        }
        return result;
    }
    
    public List<ItemDTO> getAllItems(){
        return null;
    }
    
    public Item getItemByID(Long id){
        return itemRepository.findOne(id);
    }

    public List<Item> getItemsByUser(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UserNotFoundException("Invalid user");

        return itemRepository.findAllByUser(user);
    }

    public List<Item> getAllBySubCategory(String subCategoryName) throws SubCategoryNotFoundException {
        SubCategory subCategory = subCategoryRepository.findByName(subCategoryName);

        if (subCategory == null)
            throw new SubCategoryNotFoundException("Invalid subCategory");

        return subCategory.getItems();
    }
}
