package com.product_service.Service;

import com.product_service.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> save(Category category);
    List<Category> getAll();
    Optional<Category> getOne(Long id);
    Boolean deleteOne(Long id);
    Optional<Category> update(Category category,Long id);
}
