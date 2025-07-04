// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.model.Category;
import com.dan232.pricer.comparator.port.CategoryPort;
import com.dan232.pricer.comparator.port.CategoryQueryUseCase;

import java.util.Optional;

final class GetCategoryUseCase implements CategoryQueryUseCase.GetCategory {

    private final CategoryPort categoryPort;
    private final String name;


    GetCategoryUseCase(CategoryPort categoryPort, String id) {
        this.categoryPort = categoryPort;
        this.name = id;
    }

    @Override
    public Optional<Category> perform() {
        return categoryPort.getAllCategories()
                .stream()
                .filter(category -> category
                        .name()
                        .equals(name))
                .findFirst();
    }
}
