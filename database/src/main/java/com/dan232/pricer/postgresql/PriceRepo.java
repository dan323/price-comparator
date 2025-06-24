package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.PriceRel;
import com.dan232.pricer.postgresql.entity.PriceRelId;
import com.dan232.pricer.postgresql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PriceRepo extends JpaRepository<PriceRel, PriceRelId> {

    @Query("""
        SELECT pr 
        FROM PriceRel pr 
        WHERE pr.productShop.product = :product
        """)
    Set<PriceRel> findByProduct(@Param("product") Product product);

}
