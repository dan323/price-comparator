// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.rest;

import com.dan232.pricer.comparator.model.Category;
import com.dan232.pricer.comparator.port.CategoryQueryUseCase;
import com.dan232.pricer.comparator.port.ProductQueryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryResource {

    private final CategoryQueryUseCase useCase;

    public CategoryResource(final CategoryQueryUseCase queryUseCase) {
        this.useCase = queryUseCase;
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<Category> getCategoryByName(@PathVariable("name") String name) {
        return ResponseEntity.of(useCase.getCategory(name).perform());
    }

    @GetMapping("/category")
    public ResponseEntity<Category> getTreeOfCategories(){
        return ResponseEntity.ok(useCase.getRoot().perform());
    }

}
