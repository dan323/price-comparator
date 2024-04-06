// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.dungeon;

import com.dan232.pricer.scrapper.ScrapperPort;
import org.junit.jupiter.api.Test;

public class DungeonScrapperTest {

    @Test
    public void testNew(){
        ScrapperPort scrapperAdapter = new DungeonMarvelsOffersScrapperAdapter();

        scrapperAdapter.scrapWeb().forEach(System.out::println);
    }

}
