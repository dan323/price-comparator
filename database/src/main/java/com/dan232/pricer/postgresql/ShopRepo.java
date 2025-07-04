// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepo extends JpaRepository<Shop, String> {

    /**
     * Find the shop given the name.
     *
     * @param name Name of the shop
     * @return if it exists, a shop named {@param name}
     */
    Optional<Shop> findByName(String name);
}
