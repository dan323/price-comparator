// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.rest;

import com.dan232.pricer.comparator.ProductQueryUseCase;
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

    public ProductResource(ProductQueryUseCase useCase){
        this.useCase = useCase;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductPriced> getProductById(@PathVariable String productId){
        var product = useCase.getProduct(productId).perform();
        if (product != null){
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductBasic>> getAllProducts(){
        var products = useCase.getProducts().perform();
        if (products == null || products.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @GetMapping("/product/category/{category}")
    public ResponseEntity<List<ProductBasic>> getProductsByCategory(@PathVariable String category){
        var products = useCase.getProductsByCategory(category).perform();
        if (products == null || products.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(products);
        }
    }
}
