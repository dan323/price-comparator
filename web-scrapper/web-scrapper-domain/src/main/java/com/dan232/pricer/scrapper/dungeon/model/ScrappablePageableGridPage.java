// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.dungeon.model;

import com.dan232.pricer.scrapper.dungeon.DungeonUtils;
import org.jsoup.nodes.Document;

import java.util.OptionalInt;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ScrappablePageableGridPage {

    private final Document document;

    public ScrappablePageableGridPage(Document document) {
        this.document = document;
    }

    public Stream<ScrappedGameFromGrid> stream() {
        return DungeonUtils.getProductDataFromGridPage(document)
                .map(ScrappedGameFromGrid::new);
    }

    public boolean isInError() {
        return !document.select("section.page-not-found").isEmpty();
    }
}
