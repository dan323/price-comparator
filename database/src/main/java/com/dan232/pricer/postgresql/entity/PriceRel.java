package com.dan232.pricer.postgresql.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "price_rel")
public class PriceRel {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "product"), @JoinColumn(name = "shop")})
    ProductShop productShop;
    @Id
    Date date;
    double price;

    public Product getProduct() {
        return productShop.getProduct();
    }

    public Shop getShop() {
        return productShop.getShop();
    }

    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }
}
