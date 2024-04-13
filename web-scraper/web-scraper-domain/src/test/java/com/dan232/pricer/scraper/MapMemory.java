// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper;

import com.dan232.pricer.scraper.model.WebProductPrice;
import com.dan232.pricer.scraper.port.SavePort;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of {@link SavePort} to save data in memory.
 */
public class MapMemory implements SavePort {

    private final Map<String, Map<String, WebProductPrice>> inMemoryData = new HashMap<>();

    /**
     * Save product to files.
     *
     * @param webProductPrice model to save
     */
    @Override
    public WebProductPrice save(final WebProductPrice webProductPrice) {
        if (!isInProduct(webProductPrice.EAN())) {
            saveInProduct(webProductPrice);
            return webProductPrice;
        }
        if (!isInProductInShop(webProductPrice.EAN(), webProductPrice.shopName())) {
            saveInProductInShop(webProductPrice);
            return webProductPrice;
        }
        return inMemoryData.get(webProductPrice.EAN()).get(webProductPrice.shopName());
    }

    private void saveInProductInShop(final WebProductPrice webProductPrice) {
        var mapByShop = inMemoryData.get(webProductPrice.EAN());
        mapByShop.put(webProductPrice.shopName(), webProductPrice);
    }

    private void saveInProduct(final WebProductPrice webProductPrice) {
        inMemoryData.put(webProductPrice.EAN(), new HashMap<>(Map.of(webProductPrice.shopName(), webProductPrice)));
    }

    private boolean isInProductInShop(final String ean, final String shopName) {
        return inMemoryData.get(ean).containsKey(shopName);
    }

    private boolean isInProduct(final String ean) {
        return inMemoryData.containsKey(ean);
    }

    public int shopsWithSameEan(final String ean){
        return inMemoryData.get(ean).size();
    }

}
