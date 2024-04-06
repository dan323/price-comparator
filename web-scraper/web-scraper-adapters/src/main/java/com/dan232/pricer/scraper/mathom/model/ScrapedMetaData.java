// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.mathom.model;

import com.dan232.pricer.scraper.mathom.MathomUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Optional;

public class ScrapedMetaData {

    private final Elements metadataElements;

    public ScrapedMetaData(Elements elements) {
        if (elements.stream().allMatch(element -> element.is("meta"))) {
            this.metadataElements = elements;
        } else {
            throw new RuntimeException("The elements are not metaData");
        }
    }

    public Optional<Element> filterByProperty(String property) {
        return metadataElements.stream()
                .filter(element -> element.attribute("itemprop").getValue().equals(property))
                .findFirst();
    }

    public Optional<String> getDetailsURL() {
        return filterByProperty("url")
                .map(element -> element.attribute("content")
                        .getValue())
                .map(MathomUtils::urlExtractor);
    }

    public Optional<Double> getPrice() {
        return filterByProperty("price")
                .map(element -> element.attribute("content").getValue())
                .map(Double::parseDouble);
    }
}
