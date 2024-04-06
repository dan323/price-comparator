// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.mathom;

import com.dan232.pricer.scrapper.ScrapperPort;
import com.dan232.pricer.scrapper.mathom.model.ScrappableGridPage;
import com.dan232.pricer.scrapper.model.WebProductPrice;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

public class MathomNewGamesScrapperAdapter implements ScrapperPort {

    private static final String MATHOM_URL = "https://mathom.es/es";

    @Override
    public List<WebProductPrice> scrapWeb() {
        try {
            var doc = new ScrappableGridPage(Jsoup.connect(MATHOM_URL)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                    .header("Accept-Language", "es-ES")
                    .get());
            return doc.stream().flatMap(game -> game.toModel().stream()).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new RuntimeException(new IOException(e));
        }
    }
}
