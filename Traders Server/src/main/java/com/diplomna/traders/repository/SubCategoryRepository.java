package com.diplomna.traders.repository;

import com.diplomna.traders.models.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory,Long> {
}
