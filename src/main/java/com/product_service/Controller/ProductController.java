package com.product_service.Controller;

import com.product_service.Repository.SubCategoryRepository;
import com.product_service.Service.ProductService;
import com.product_service.entities.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products products){
        return ResponseEntity.ok(this.productService.save(products).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProduct(Long id){
        return this.productService.getOne(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProduct(Long id){
        return this.productService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@RequestBody Products products,Long id){
        return this.productService.update(products,id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
