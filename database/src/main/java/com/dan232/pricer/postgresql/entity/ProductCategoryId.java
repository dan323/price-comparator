package com.dan232.pricer.postgresql.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class ProductCategoryId implements Serializable {

    private BigInteger product;  // tipo igual que Product.ean
    private Long category;         // tipo igual que Category.id

    // Constructor sin argumentos (obligatorio)
    public ProductCategoryId() {}

    public ProductCategoryId(BigInteger product, Long category) {
        this.product = product;
        this.category = category;
    }

    // getters y setters

    public BigInteger getProduct() {
        return product;
    }

    public void setProduct(BigInteger product) {
        this.product = product;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    // equals y hashCode (muy importante)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCategoryId that)) return false;
        return Objects.equals(product, that.product) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, category);
    }
}