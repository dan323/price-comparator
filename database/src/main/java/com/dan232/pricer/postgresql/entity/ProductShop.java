package com.dan232.pricer.postgresql.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_shop")
public class ProductShop {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop")
    @Id
    private Shop shop;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product")
    @Id
    private Product product;

    private String buyUrl;

    public Shop getShop() {
        return shop;
    }

    public Product getProduct() {
        return product;
    }
}
