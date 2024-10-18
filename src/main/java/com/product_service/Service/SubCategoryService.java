package com.product_service.Service;

import com.product_service.entities.Category;
import com.product_service.entities.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryService {
    Optional<SubCategory> save(SubCategory subCategory);
    List<SubCategory> getAll();
    Optional<SubCategory> getOne(Long id);
    Boolean deleteOne(Long id);
    Optional<SubCategory> update(SubCategory subCategory,Long id);
}
