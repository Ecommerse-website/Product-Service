package com.product_service.Impl;

import com.product_service.Repository.ProductRepository;
import com.product_service.Service.ProductService;
import com.product_service.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Products> save(Products products) {
        return Optional.of(this.productRepository.save(products));
    }

    @Override
    public List<Products> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Products> getOne(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Products> data = this.getOne(id);
        if (data.isPresent()){
            this.productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Products> update(Products products, Long id) {
        if(!this.productRepository.existsById(id)){
            return Optional.empty();
        }

        products.setProductId(id);
        return Optional.of(this.productRepository.save(products));
    }
}
