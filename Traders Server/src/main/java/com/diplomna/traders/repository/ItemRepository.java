package com.diplomna.traders.repository;

import com.diplomna.traders.models.Item;
import com.diplomna.traders.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
    List<Item> findAllByUser(User user);


}
