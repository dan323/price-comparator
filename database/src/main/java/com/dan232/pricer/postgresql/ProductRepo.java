package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Set;

@Repository
public interface ProductRepo extends JpaRepository<Product, BigInteger> {

    @Query("SELECT pc.product FROM ProductCategory pc WHERE pc.category.name = :category")
    Set<Product> findByCategory(@Param("category") String category);

}
