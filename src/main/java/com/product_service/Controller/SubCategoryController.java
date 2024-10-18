package com.product_service.Controller;

import com.product_service.Service.CategoryService;
import com.product_service.Service.SubCategoryService;
import com.product_service.entities.Category;
import com.product_service.entities.SubCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub-categories")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    private final Logger logger = LoggerFactory.getLogger(SubCategoryController.class);

    @PostMapping
    public ResponseEntity<SubCategory> createCategory(@RequestBody SubCategory subCategory){
        logger.info("subCategory "+subCategory);
        return ResponseEntity.ok(this.subCategoryService.save(subCategory).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<SubCategory>> getAllCategories(){
        return ResponseEntity.ok(subCategoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategory> getCategory(Long id){
        return this.subCategoryService.getOne(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(Long id){
        return this.subCategoryService.deleteOne(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategory> updateCategory(SubCategory subCategory,Long id){
        return this.subCategoryService.update(subCategory,id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
