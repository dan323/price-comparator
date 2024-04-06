// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.mathom;

import com.dan232.pricer.scrapper.ScrapperPort;
import org.junit.jupiter.api.Test;

public class MathomScrapperTest {

    @Test
    public void testNew(){
        ScrapperPort scrapperAdapter = new MathomNewGamesScrapperAdapter();

        scrapperAdapter.scrapWeb().forEach(System.out::println);
    }

    @Test
    public void testOffer(){
        ScrapperPort scrapperAdapter = new MathomOffersScrapperAdapter();

        scrapperAdapter.scrapWeb().forEach(System.out::println);
    }
}
