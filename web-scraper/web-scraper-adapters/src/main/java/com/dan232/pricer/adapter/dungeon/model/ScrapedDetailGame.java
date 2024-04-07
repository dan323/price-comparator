// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.dungeon.model;

import com.dan232.pricer.adapter.EANUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Optional;

public class ScrapedDetailGame {
    private final Document document;

    public ScrapedDetailGame(final Document detailGameDocument) {
        this.document = detailGameDocument;
    }

    /**
     * @return game name is found, empty if not
     */
    public Optional<String> getName() {
        return Optional.ofNullable(document
                        .selectFirst("h1.product-title"))
                .map(Element::text);
    }

    /**
     * @return EAN number is found, empty if not
     */
    public Optional<String> getEAN() {
        return document.select("div.product-reference span")
                .stream()
                .filter(span -> span
                        .attribute("itemprop")
                        .getValue()
                        .equals("gtin13"))
                .findFirst()
                .map(Element::text)
                .filter(EANUtil::validateEAN13);
    }
}
