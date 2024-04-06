// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.mathom.model;

import com.dan232.pricer.scraper.mathom.MathomUtils;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.stream.Stream;

public class ScrapableGridPage {

    protected final Document document;

    public ScrapableGridPage(Document document){
        this.document = document;
    }

    public Stream<ScrapedGameFromGrid> stream() throws IOException {
        return MathomUtils.getProductDataFromGridPage(document)
                .map(ScrapedGameFromGrid::new);
    }
}
