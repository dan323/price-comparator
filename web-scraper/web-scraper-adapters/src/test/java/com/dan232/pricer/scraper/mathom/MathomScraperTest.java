// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.mathom;

import com.dan232.pricer.scraper.ScraperPort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathomScraperTest {

    @Test
    public void testNew(){
        ScraperPort scraperAdapter = new MathomNewGamesScraperAdapter();

        if (scraperAdapter.scrapWeb().isEmpty()){
            Assertions.fail();
        }
    }

    @Test
    public void testOffer(){
        MathomOffersScraperAdapter scraperAdapter = new MathomOffersScraperAdapter();

        if (scraperAdapter.scrapWeb(2).isEmpty()){
            Assertions.fail();
        }
    }
}
