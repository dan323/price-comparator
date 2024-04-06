// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.dungeon.model;

import com.dan232.pricer.scraper.dungeon.DungeonUtils;
import org.jsoup.nodes.Document;

import java.util.stream.Stream;

public class ScrapablePageableGridPage {

    private final Document document;

    public ScrapablePageableGridPage(Document document) {
        this.document = document;
    }

    public Stream<ScrapedGameFromGrid> stream() {
        return DungeonUtils.getProductDataFromGridPage(document)
                .map(ScrapedGameFromGrid::new);
    }

    public boolean isInError() {
        return !document.select("section.page-not-found").isEmpty();
    }
}
