// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.mathom;

import com.dan232.pricer.scraper.ScraperPort;
import org.junit.jupiter.api.Test;

public class MathomScraperTest {

    @Test
    public void testNew(){
        ScraperPort scraperAdapter = new MathomNewGamesScraperAdapter();

        scraperAdapter.scrapWeb().forEach(System.out::println);
    }

    @Test
    public void testOffer(){
        ScraperPort scraperAdapter = new MathomOffersScraperAdapter();

        scraperAdapter.scrapWeb().forEach(System.out::println);
    }
}
