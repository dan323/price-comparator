// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator.port;

import com.dan232.pricer.comparator.model.ProductBasic;
import com.dan232.pricer.comparator.model.ProductPriced;

import java.util.List;
import java.util.Optional;

public interface ProductQueryUseCase {

    /**
     * Retrieve the action to get all products.
     * @return use case to get all
     */
    GetAllProducts getProducts();

    /**
     * Retrieve action to get specific product.
     * @param id product id
     * @return use case to retrieve one product
     */
    GetProduct getProduct(String id);

    /**
     * Retrieve action to get all products of a category.
     * @param category of products
     * @return use case to get all product of a category
     */

    GetProductsByCategory getProductsByCategory(String category);

    interface GetAllProducts {
        /**
         * @return all products without details
         */
        List<ProductBasic> perform();
    }

    interface GetProduct {
        /**
         * @return one product with all details
         */
        Optional<ProductPriced> perform();
    }

    interface GetProductsByCategory {
        /**
         * @return all products of a category without details
         */
        List<ProductBasic> perform();
    }

}
