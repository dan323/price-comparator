// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.rest;

import com.dan232.pricer.comparator.port.ProductQueryUseCase;
import com.dan232.pricer.comparator.model.ProductBasic;
import com.dan232.pricer.comparator.model.ProductPriced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductResource {

    private final ProductQueryUseCase useCase;

    public ProductResource(final ProductQueryUseCase queryUseCase) {
        this.useCase = queryUseCase;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductPriced>
    getProductById(final @PathVariable String productId) {
        return useCase.getProduct(productId).perform()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductBasic>> getAllProducts() {
        var products = useCase.getProducts().perform();
        if (products == null || products.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<ProductBasic>>
    getProductsByCategory(final @PathVariable String category) {
        var products = useCase.getProductsByCategory(category).perform();
        if (products == null || products.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }
}
