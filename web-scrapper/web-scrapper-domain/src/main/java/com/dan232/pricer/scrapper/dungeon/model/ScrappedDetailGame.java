// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.dungeon.model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Optional;

public class ScrappedDetailGame {
    private final Document document;

    public ScrappedDetailGame(Document document) {
        this.document = document;
    }

    public Optional<String> getName(){
        return Optional.ofNullable(document.selectFirst("h1.product-title"))
                .map(Element::text);
    }

}
