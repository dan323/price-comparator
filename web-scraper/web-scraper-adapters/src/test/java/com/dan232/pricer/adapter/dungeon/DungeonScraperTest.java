// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.dungeon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DungeonScraperTest {

    @Test
    public void testNew(){
        DungeonMarvelsOffersScraperAdapter scraperAdapter = new DungeonMarvelsOffersScraperAdapter();

        if (scraperAdapter.scrapWeb(2).isEmpty()){
            Assertions.fail();
        }
    }

}
