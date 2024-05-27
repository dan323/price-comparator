package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.model.ProductPriced;
import com.dan232.pricer.comparator.port.ProductPort;
import com.dan232.pricer.comparator.port.ProductQueryUseCase;

import java.util.Optional;

public class GetProductUseCase implements ProductQueryUseCase.GetProduct {

    private final ProductPort productPort;
    private final String id;


    public GetProductUseCase(ProductPort productPort, String id) {
        this.productPort = productPort;
        this.id = id;
    }

    @Override
    public Optional<ProductPriced> perform() {
        return productPort.getProductByEan(id);
    }
}
