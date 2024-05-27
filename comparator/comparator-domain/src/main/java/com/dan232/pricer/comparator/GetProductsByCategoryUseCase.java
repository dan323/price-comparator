package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.model.ProductBasic;
import com.dan232.pricer.comparator.port.ProductPort;
import com.dan232.pricer.comparator.port.ProductQueryUseCase;

import java.util.ArrayList;
import java.util.List;

public class GetProductsByCategoryUseCase implements ProductQueryUseCase.GetProductsByCategory {

    private final ProductPort productPort;
    private final String category;

    public GetProductsByCategoryUseCase(ProductPort productPort, String category) {
        this.productPort = productPort;
        this.category = category;
    }

    @Override
    public List<ProductBasic> perform() {
        return new ArrayList<>(productPort.getProductsByCategory(category));
    }
}
