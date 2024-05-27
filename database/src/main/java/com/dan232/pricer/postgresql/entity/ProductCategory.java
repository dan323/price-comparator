package com.dan232.pricer.postgresql.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_category")
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
