package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.PriceRel;
import com.dan232.pricer.postgresql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Set;

@Repository
public interface PriceRepo extends JpaRepository<PriceRel, BigInteger> {

    Set<PriceRel> findByProduct(Product ean);

}
