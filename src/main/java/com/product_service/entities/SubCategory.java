package com.product_service.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subCategoryName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subCategory",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Products> products;
}
