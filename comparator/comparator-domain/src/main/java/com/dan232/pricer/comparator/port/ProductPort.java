package com.dan232.pricer.comparator.port;

import com.dan232.pricer.comparator.model.ProductBasic;
import com.dan232.pricer.comparator.model.ProductPriced;

import java.util.Optional;
import java.util.Set;

public interface ProductPort {
    Set<ProductBasic> getAllProducts();
    Set<ProductBasic> getProductsByCategory(String category);
    Optional<ProductPriced> getProductByEan(String id);
}
