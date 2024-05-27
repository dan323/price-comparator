// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql;

import com.dan232.pricer.postgresql.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {

    default Set<Category> topCategories() {
        return findAll().stream()
                .filter(category -> category.getSuperCategories().isEmpty())
                .collect(Collectors.toSet());
    }

}
