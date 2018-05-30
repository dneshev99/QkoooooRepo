package com.diplomna.traders.business.logic;

import com.diplomna.traders.dtos.ItemDTO;
import com.diplomna.traders.models.Item;
import com.diplomna.traders.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemHandler {

    @Autowired
    private ItemRepository itemRepository;

    public void createNewItem(List<ItemDTO> newItems){

        if(newItems != null) {
            for (ItemDTO newItem:newItems) {

                Item item = new Item();
                item.setName(newItem.getName());
                item.setDescription(newItem.getDescription());
                item.setBasePricePerUnit(newItem.getBasePricePerUnit());

                itemRepository.save(item);
            }
        }
    }
    
    public List<ItemDTO> getAllItems(){
        return null;
    }
    
    public Item getItemByID(Long id){
        return itemRepository.findOne(id);
    }
}
