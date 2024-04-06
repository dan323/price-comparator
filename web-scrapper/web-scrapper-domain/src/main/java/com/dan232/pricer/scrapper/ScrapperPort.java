// Copyright (c) 2022 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper;

import com.dan232.pricer.scrapper.model.WebProductPrice;

import java.util.List;

public interface ScrapperPort {

    /**
     * Scrap the website for pricing information of products
     *
     * @return list of pricing information
     */
    List<WebProductPrice> scrapWeb();

}
