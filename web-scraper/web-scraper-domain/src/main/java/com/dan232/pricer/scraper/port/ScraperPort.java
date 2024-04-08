// Copyright (c) 2022 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.port;

import com.dan232.pricer.scraper.model.WebProductPrice;

import java.util.List;

public interface ScraperPort {

    /**
     * Scrap the website for pricing information of products.
     *
     * @return list of pricing information
     */
    List<WebProductPrice> scrapWeb();

}
