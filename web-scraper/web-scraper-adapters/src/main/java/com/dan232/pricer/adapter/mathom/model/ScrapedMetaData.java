// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.mathom.model;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Optional;

public class ScrapedMetaData {

    private final Elements metadataElements;

    public ScrapedMetaData(final Elements elements) {
        if (elements.stream().allMatch(element -> element.is("meta"))) {
            this.metadataElements = elements;
        } else {
            throw new RuntimeException("The elements are not metaData");
        }
    }

    private Optional<Element> filterByProperty(final String property) {
        return metadataElements.stream()
                .filter(element -> element
                        .attribute("itemprop")
                        .getValue()
                        .equals(property))
                .findFirst();
    }

    /**
     * @return url to detailed view
     */
    public Optional<String> getDetailsURL() {
        return filterByProperty("url")
                .map(element -> element.attribute("content")
                        .getValue())
                .map(MathomUtils::urlExtractor);
    }

    /**
     * @return price of game
     */
    public Optional<Double> getPrice() {
        return filterByProperty("price")
                .map(element -> element
                        .attribute("content")
                        .getValue()
                ).map(Double::parseDouble);
    }
}
