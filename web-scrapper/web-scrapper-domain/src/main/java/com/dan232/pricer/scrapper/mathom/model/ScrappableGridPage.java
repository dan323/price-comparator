// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.mathom.model;

import com.dan232.pricer.scrapper.mathom.MathomUtils;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.stream.Stream;

public class ScrappableGridPage {

    protected final Document document;

    public ScrappableGridPage(Document document){
        this.document = document;
    }

    public Stream<ScrappedGameFromGrid> stream() throws IOException {
        return MathomUtils.getProductDataFromGridPage(document)
                .map(ScrappedGameFromGrid::new);
    }
}
