package com.dan232.pricer.comparator.model;

import java.util.List;

public record GamePriced(GameBasic gameBasic, List<ShopPrice> priceList) {
}
