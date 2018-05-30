package com.diplomna.traders.repository;

import com.diplomna.traders.models.Category;
import com.diplomna.traders.models.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory,Long> {
    SubCategory findByName(String name);
    List<SubCategory> findAllByCategory(Category category);
}
