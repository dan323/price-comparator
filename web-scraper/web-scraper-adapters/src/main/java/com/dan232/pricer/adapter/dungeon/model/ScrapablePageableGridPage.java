// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.dungeon.model;

import org.jsoup.nodes.Document;

import java.util.stream.Stream;

public class ScrapablePageableGridPage {

    private final Document document;

    public ScrapablePageableGridPage(final Document pageGridDocument) {
        this.document = pageGridDocument;
    }

    /**
     * @return stream of all games in this grid page
     */
    public Stream<ScrapedGameFromGrid> stream() {
        return DungeonUtils.getProductDataFromGridPage(document)
                .map(ScrapedGameFromGrid::new);
    }

    /**
     * Checks if the document is in fact an
     * error page instead of a product grid.
     * @return true iff an error page
     */
    public boolean isInError() {
        return !document.select("section.page-not-found").isEmpty();
    }
}
