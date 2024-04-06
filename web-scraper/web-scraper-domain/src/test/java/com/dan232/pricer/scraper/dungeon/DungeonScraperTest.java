// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.dungeon;

import com.dan232.pricer.scraper.ScraperPort;
import org.junit.jupiter.api.Test;

public class DungeonScraperTest {

    @Test
    public void testNew(){
        ScraperPort scraperAdapter = new DungeonMarvelsOffersScraperAdapter();

        scraperAdapter.scrapWeb().forEach(System.out::println);
    }

}
