// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private BigInteger ean;

    private String name;

    private String image;

    @OneToMany(mappedBy = "product")
    private Set<ProductCategory> categories;

    public Set<Category> getCategories() {
        return categories.stream()
                .map(ProductCategory::getCategory)
                .collect(Collectors.toSet());
    }

    public BigInteger getEan() {
        return ean;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void setEan(BigInteger ean) {
        this.ean = ean;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product {EAN=" + ean
                + ";NAME=" + name
                + ";IMAGE=" + image
                + ";CATS=" + categories + "}";
    }
}
