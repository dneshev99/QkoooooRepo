package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.ItemDTO;
import com.diplomna.traders.models.Item;
import com.diplomna.traders.models.SubCategory;
import com.diplomna.traders.models.User;
import com.diplomna.traders.repository.ItemRepository;
import com.diplomna.traders.repository.SubCategoryRepository;
import com.diplomna.traders.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemHandler {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public List<Long> createNewItem(List<ItemDTO> newItems){

        List<Long> result = new ArrayList<>();

        if(newItems != null) {
            for (ItemDTO newItem:newItems) {

                User user = userRepository.findByUsername(newItem.getUser());
                SubCategory subCategory = subCategoryRepository.findByName(newItem.getCategory());

                Item item = new Item();
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                item.setBasePricePerUnit(newItem.getBasePricePerUnit());
                item.setUser(user);
                item.setSubCategory(subCategory);

                result.add(itemRepository.save(item).getId());
            }
        }
        return result;
    }
    
    public List<ItemDTO> getAllItems(){
        return null;
    }
    
    public Item getItemByID(Long id){
        return itemRepository.findOne(id);
    }
}
