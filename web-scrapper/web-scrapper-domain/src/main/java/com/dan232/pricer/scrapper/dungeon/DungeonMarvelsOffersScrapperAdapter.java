// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.dungeon;

import com.dan232.pricer.scrapper.ScrapperPort;
import com.dan232.pricer.scrapper.dungeon.model.ScrappablePageableGridPage;
import com.dan232.pricer.scrapper.model.WebProductPrice;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DungeonMarvelsOffersScrapperAdapter implements ScrapperPort {

    private static final String DUNGEON_MARVELS_OFFER_URL = "https://dungeonmarvels.com/1397-rebajas-juegos";
    private static final int PAGE_LIMIT = 100;

    @Override
    public List<WebProductPrice> scrapWeb() {
        var ids = new ArrayList<WebProductPrice>();
        int page = 1;
        try {
            while (page <= PAGE_LIMIT) {
                var doc = new ScrappablePageableGridPage(Jsoup.connect(DUNGEON_MARVELS_OFFER_URL + "?page=" + page)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                        .header("Accept-Language", "es-ES")
                        .get());
                if (doc.isInError()) {
                    break;
                }
                System.out.println("PAGE: "+page);

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
