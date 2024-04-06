// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.dungeon.model;

import com.dan232.pricer.scraper.model.WebProductPrice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Optional;
import java.util.regex.Pattern;

public class ScrapedGameFromGrid {

    private final Element game;

    public ScrapedGameFromGrid(Element element) {
        this.game = element;
    }

    public Optional<WebProductPrice> toModel() {
        return getDetailURL().flatMap(url -> goTo().flatMap(detail -> detail.getName().flatMap(name -> getPrice().map(price ->
        {
            try {
                return new WebProductPrice(name + "#DUNGEON", name, price, URI.create(url).toURL(), 5.90);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }))));
    }

    private Optional<ScrapedDetailGame> goTo(){
        return getDetailURL().map(url -> {
            try {
                return new ScrapedDetailGame(Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                        .header("Accept-Language", "es-ES")
                        .get());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Optional<String> getDetailURL() {
        return Optional.ofNullable(game.selectFirst("a"))
                .map(element -> element.attribute("href"))
                .map(Attribute::getValue);
    }

    public Optional<Double> getPrice() {
        return Optional.ofNullable(game.selectFirst("div.product-price-and-shipping span.price"))
                .map(Element::text)
                .map(value -> {
                    var pattern = Pattern.compile("(\\d+,\\d\\d)\\s.*");
                    var matcher = pattern.matcher(value);
                    if (matcher.matches()) {
                        return Double.parseDouble(matcher.group(1).replace(",", "."));
                    } else {
                        throw new RuntimeException(new IOException("The price could not be parsed."));
                    }
                });
    }
}
