package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.Product;
import com.dan232.pricer.postgresql.entity.ProductShop;
import com.dan232.pricer.postgresql.entity.ProductShopId;
import com.dan232.pricer.postgresql.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductShopRepo extends JpaRepository<ProductShop, ProductShopId> {
    Optional<ProductShop> findByProductAndShop(Product product, Shop shop);
}