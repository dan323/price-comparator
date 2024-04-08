// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.dungeon;

import com.dan232.pricer.adapter.dungeon.model.ScrapablePageableGridPage;
import com.dan232.pricer.scraper.port.ScraperPort;
import com.dan232.pricer.scraper.model.WebProductPrice;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DungeonMarvelsOffersScraperAdapter implements ScraperPort {

    private static final String DUNGEON_MARVELS_OFFER_URL =
            "https://dungeonmarvels.com/1397-rebajas-juegos";
    private static final int PAGE_LIMIT = 100;

    // Done this way to be able to test limiting
    // the number of pages to search for
    List<WebProductPrice> scrapWeb(final int maxPage) {
        var ids = new ArrayList<WebProductPrice>();
        int page = 1;
        try {
            while (page <= maxPage) {
                var doc = new ScrapablePageableGridPage(Jsoup
                        .connect(DUNGEON_MARVELS_OFFER_URL + "?page=" + page)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
                                + " AppleWebKit/537.36 (KHTML, like Gecko) "
                                + "Chrome/108.0.0.0 Safari/537.36")
                        .header("Accept-Language", "es-ES")
                        .get());
                if (doc.isInError()) {
                    break;
                }

                ids.addAll(doc.stream()
                        .flatMap(game -> game
                                .toModel()
                                .stream())
                        .toList());
                page++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new RuntimeException(new IOException(e));
        }
        return ids;
    }

    @Override
    public List<WebProductPrice> scrapWeb() {
        return scrapWeb(PAGE_LIMIT);
    }

}
