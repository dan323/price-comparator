// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.mathom.model;

import com.dan232.pricer.scraper.mathom.MathomUtils;
import com.dan232.pricer.scraper.model.WebProductPrice;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Optional;

public class ScrapedGameFromGrid {

    private final Element game;

    public ScrapedGameFromGrid(Element game) {
        if (game.is("div.pro_second_box")) {
            this.game = game;
        } else {
            throw new RuntimeException(new IOException("This element is not the product the scraper is implemented for."));
        }
    }

    public ScrapedMetaData getMeta() {
        return new ScrapedMetaData(game.select("meta"));
    }

    public Optional<String> getName() {
        return Optional.ofNullable(game.selectFirst("a.product-name"))
                .map(element -> element.attribute("title"))
                .map(Attribute::getValue);
    }

    public Optional<WebProductPrice> toModel() {
        return getName().flatMap(name -> getMeta().getPrice().flatMap(price -> getMeta().getDetailsURL().map(url ->
        {
            try {
                return new WebProductPrice(name + "@MATHOM", name, price, URI.create(url).toURL(), MathomUtils.sendPrice(price));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        })));
    }
}
