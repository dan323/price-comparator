package com.dan232.pricer.scraper;

import com.dan232.pricer.scraper.port.ScraperPort;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

public class Adapters {

    public static ScraperPort threeProductsWithEAN(String ean) {
        return () -> {
            try {
                return List.of(Models.randomWithEan(ean,1), Models.randomWithEan(ean,2), Models.randomWithEan(ean,3));
            } catch (URISyntaxException | MalformedURLException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
