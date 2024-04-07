// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator;

import org.springframework.stereotype.Component;

@Component
public final class ProductQueryUseCaseImpl implements ProductQueryUseCase {
    @Override
    public GetAllProducts getProducts() {
        return null;
    }

    @Override
    public GetProduct getProduct(final String id) {
        return null;
    }

    @Override
    public GetProductsByCategory getProductsByCategory(final String category) {
        return null;
    }
}
