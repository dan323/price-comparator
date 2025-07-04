// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator.model;

import java.util.List;

public record ProductPriced(ProductBasic productBasic,
                            List<ShopPrice> priceList) {

    public ProductPriced(ProductBasic productBasic, List<ShopPrice> priceList) {
        var min = priceList.stream().mapToDouble(ShopPrice::price).min();
        this.productBasic = new ProductBasic(productBasic.name(),
                productBasic.ean(),
                min.orElse(Double.NaN),
                productBasic.categories(),
                productBasic.image());
        this.priceList = priceList;
    }

}
