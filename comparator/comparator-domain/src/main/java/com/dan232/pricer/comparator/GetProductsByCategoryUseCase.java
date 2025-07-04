// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.model.ProductBasic;
import com.dan232.pricer.comparator.port.ProductPort;
import com.dan232.pricer.comparator.port.ProductQueryUseCase;

import java.util.ArrayList;
import java.util.List;

final class GetProductsByCategoryUseCase implements
        ProductQueryUseCase.GetProductsByCategory {

    private final ProductPort productPort;
    private final String category;

    GetProductsByCategoryUseCase(ProductPort productPort, String category) {
        this.productPort = productPort;
        this.category = category;
    }

    @Override
    public List<ProductBasic> perform() {
        return new ArrayList<>(productPort.getProductsByCategory(category));
    }
}
