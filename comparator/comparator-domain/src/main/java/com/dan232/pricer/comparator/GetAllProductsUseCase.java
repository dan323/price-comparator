package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.model.ProductBasic;
import com.dan232.pricer.comparator.port.ProductPort;
import com.dan232.pricer.comparator.port.ProductQueryUseCase;

import java.util.ArrayList;
import java.util.List;

public class GetAllProductsUseCase implements ProductQueryUseCase.GetAllProducts {

    private final ProductPort productPort;

    public GetAllProductsUseCase(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public List<ProductBasic> perform() {
        return new ArrayList<>(productPort.getAllProducts());
    }
}
