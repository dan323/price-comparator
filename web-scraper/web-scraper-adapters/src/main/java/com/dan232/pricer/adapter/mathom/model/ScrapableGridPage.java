// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.mathom.model;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.stream.Stream;

public class ScrapableGridPage {

    private final Document document;

    /**
     * @return document of the page
     */
    protected Document getDocument() {
        return document;
    }

    public ScrapableGridPage(final Document gridPageDocument) {
        this.document = gridPageDocument;
    }

    /**
     * @return stream with all games in the grid
     * @throws IOException in case the document is not a grid page
     */
    public Stream<ScrapedGameFromGrid> stream() throws IOException {
        return MathomUtils.getProductDataFromGridPage(document)
                .map(ScrapedGameFromGrid::new);
    }
}
