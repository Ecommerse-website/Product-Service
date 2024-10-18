package com.product_service.Service;

import com.product_service.entities.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Products> save(Products products);
    List<Products> getAll();
    Optional<Products> getOne(Long id);
    Boolean delete(Long id);
    Optional<Products> update(Products products,Long id);
}
