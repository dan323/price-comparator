package com.dan232.pricer.scraper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ScrapWebsiteUseCaseTest {

    UseCaseBeanConfiguration beanConfiguration = new UseCaseBeanConfiguration();

    @Test
    public void sameEanDifferentWebsites() {
        var memory =  new MapMemory();
        var ean = Models.randomEan();
        var scrapWebsite = beanConfiguration.scrapWebsite(List.of(Adapters.threeProductsWithEAN(ean)), memory);
        scrapWebsite.scrap().perform();
        int size = memory.shopsWithSameEan(ean);
        Assertions.assertEquals(3, size);
    }
}
