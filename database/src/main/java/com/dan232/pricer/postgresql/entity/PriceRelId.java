package com.dan232.pricer.postgresql.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PriceRelId implements Serializable {

    private ProductShop productShop;  // tipo igual que Product.ean
    private Date date;         // tipo igual que Shop.id

    // Constructor sin argumentos (obligatorio)
    public PriceRelId() {}

    public PriceRelId(ProductShop productShop, Date date) {
        this.productShop = productShop;
        this.date = date;
    }

    // getters y setters

    public ProductShop getProductShop() {
        return productShop;
    }

    public void setProductShop(ProductShop product) {
        this.productShop = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date shop) {
        this.date = date;
    }

    // equals y hashCode (muy importante)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PriceRelId that)) return false;
        return Objects.equals(productShop, that.productShop) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
    return Objects.hash(productShop, date);
}
}