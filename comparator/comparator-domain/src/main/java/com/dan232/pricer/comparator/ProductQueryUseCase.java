// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.model.ProductBasic;
import com.dan232.pricer.comparator.model.ProductPriced;

import java.util.List;

public interface ProductQueryUseCase {

    GetAllProducts getProducts();

    GetProduct getProduct(String id);

    GetProductsByCategory getProductsByCategory(String category);

    interface GetAllProducts{
        List<ProductBasic> perform();
    }

    interface GetProduct{
        ProductPriced perform();
    }

    interface GetProductsByCategory{
        List<ProductBasic> perform();
    }

}
