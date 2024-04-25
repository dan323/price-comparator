// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.mathom;

import com.dan232.pricer.scraper.port.ScraperPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathomScraperTest {

    @Test
    public void testNew(){
        ScraperPort scraperAdapter = new MathomNewGamesScraperAdapter();

        Assertions.assertFalse(scraperAdapter.scrapWeb().isEmpty());
    }

    @Test
    public void testOffer(){
        MathomOffersScraperAdapter scraperAdapter = new MathomOffersScraperAdapter();

        Assertions.assertFalse(scraperAdapter.scrapWeb(2).isEmpty());
    }
}
