package com.product_service.Impl;

import com.product_service.Repository.CategoryRepository;
import com.product_service.Service.CategoryService;
import com.product_service.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> save(Category category) {
        return Optional.of(this.categoryRepository.save(category));
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getOne(Long id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public Boolean deleteOne(Long id) {
        Optional<Category> data = getOne(id);
        if (data.isPresent()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Category> update(Category category, Long id) {
        if(!this.categoryRepository.existsById(id)){
            return Optional.empty();
        }

        category.setCategoryId(id);
        return Optional.of(this.categoryRepository.save(category));
    }
}
