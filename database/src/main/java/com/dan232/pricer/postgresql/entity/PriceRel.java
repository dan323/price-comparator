// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "price_rel")
@IdClass(PriceRelId.class)
public class PriceRel {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "product"), @JoinColumn(name = "shop")})
    private ProductShop productShop;
    @Id
    private Date date;
    private double price;

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

    public void setProductShop(ProductShop productShop) {
        this.productShop = productShop;
    }

    public void setDateAsNow() {
        this.date = new Date();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
