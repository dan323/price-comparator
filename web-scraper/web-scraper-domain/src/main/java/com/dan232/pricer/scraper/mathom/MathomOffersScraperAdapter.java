// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.mathom;

import com.dan232.pricer.scraper.ScraperPort;
import com.dan232.pricer.scraper.mathom.model.ScrapablePageableGridPage;
import com.dan232.pricer.scraper.model.WebProductPrice;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MathomOffersScraperAdapter implements ScraperPort {

    private static final String MATHOM_URL = "https://mathom.es/es/2507-ofertas?n=100";
    private static final int PAGE_LIMIT = 100;

    @Override
    public List<WebProductPrice> scrapWeb() {
        var ids = new ArrayList<WebProductPrice>();
        int page = 1;
        try {
            while (page <= PAGE_LIMIT) {
                var doc = new ScrapablePageableGridPage(Jsoup.connect(MATHOM_URL + "&p=" + page)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                        .header("Accept-Language", "es-ES")
                        .get());
                if (doc.getPageNumber().isEmpty()) {
                    break;
                }

                ids.addAll(doc.stream().flatMap(game -> game.toModel().stream()).toList());
                page++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new RuntimeException(new IOException(e));
        }
        return ids;
    }
}
