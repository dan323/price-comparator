// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.port.CategoryPort;
import com.dan232.pricer.comparator.port.CategoryQueryUseCase;
import com.dan232.pricer.comparator.port.ProductPort;
import com.dan232.pricer.comparator.port.ProductQueryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComparatorUseCaseConfiguration {

    @Bean
    CategoryQueryUseCase categoryQueryUseCase(CategoryPort categoryPort){
        return new CategoryQueryUseCase() {
            @Override
            public GetRootCategory getRoot() {
                return new GetRootCategoryUseCase(categoryPort);
            }

            @Override
            public GetCategory getCategory(String id) {
                return new GetCategoryUseCase(categoryPort, id);
            }
        };
    }

    @Bean
    ProductQueryUseCase productQueryUseCase(ProductPort productPort){
        return new ProductQueryUseCase() {
            @Override
            public GetAllProducts getProducts() {
                return new GetAllProductsUseCase(productPort);
            }

            @Override
            public GetProduct getProduct(String id) {
                return new GetProductUseCase(productPort, id);
            }

            @Override
            public GetProductsByCategory getProductsByCategory(String category) {
                return new GetProductsByCategoryUseCase(productPort, category);
            }
        };
    }
}
