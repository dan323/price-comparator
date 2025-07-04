// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class ProductShopId implements Serializable {

    private BigInteger product;  // tipo igual que Product.ean
    private Long shop;         // tipo igual que Shop.id

    // Constructor sin argumentos (obligatorio)
    public ProductShopId() {
    }

    public ProductShopId(BigInteger product, Long shop) {
        this.product = product;
        this.shop = shop;
    }

    // getters y setters

    public BigInteger getProduct() {
        return product;
    }

    public void setProduct(BigInteger product) {
        this.product = product;
    }

    public Long getShop() {
        return shop;
    }

    public void setShop(Long shop) {
        this.shop = shop;
    }

    // equals y hashCode (muy importante)

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductShopId that)) {
            return false;
        }
        return Objects.equals(product, that.product)
                && Objects.equals(shop, that.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, shop);
    }
}
