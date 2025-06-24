package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepo extends JpaRepository<Shop, String> {

    Optional<Shop> findByName(String name);
}
