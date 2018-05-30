package com.diplomna.traders.repository;

import com.diplomna.traders.models.Category;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    Category findByName(String name);
}
