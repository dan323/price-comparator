// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.Product;
import com.dan232.pricer.postgresql.entity.ProductShop;
import com.dan232.pricer.postgresql.entity.ProductShopId;
import com.dan232.pricer.postgresql.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductShopRepo extends
        JpaRepository<ProductShop, ProductShopId> {
    /**
     * Find the product in a shop.
     *
     * @param product Product to find
     * @param shop Shop to be found in
     * @return a product sold in a specific shop
     */
    Optional<ProductShop> findByProductAndShop(Product product, Shop shop);
}
