package com.product_service.Impl;

import com.product_service.Repository.SubCategoryRepository;
import com.product_service.Service.SubCategoryService;
import com.product_service.entities.SubCategory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryImpl implements SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public Optional<SubCategory> save(SubCategory subCategory) {
        return Optional.of(this.subCategoryRepository.save(subCategory));
    }

    @Override
    public List<SubCategory> getAll() {
        return this.subCategoryRepository.findAll();
    }

    @Override
    public Optional<SubCategory> getOne(Long id) {
        return this.subCategoryRepository.findById(id);
    }

    @Override
    public Boolean deleteOne(Long id) {
        Optional<SubCategory> data = Optional.of(this.subCategoryRepository.getOne(id));
        if(data.isPresent()){
            this.subCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<SubCategory> update(SubCategory subCategory, Long id) {
        if(!this.subCategoryRepository.existsById(id)){
            return Optional.empty();
        }

        subCategory.setId(id);
        return Optional.of(this.subCategoryRepository.save(subCategory));
    }
}
