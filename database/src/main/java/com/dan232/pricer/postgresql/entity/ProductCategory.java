// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_category")
@IdClass(ProductCategoryId.class)
public class ProductCategory {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    @Id
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product")
    @Id
    private Product product;

    public Category getCategory() {
        return category;
    }

    public Product getProduct() {
        return product;
    }
}
