// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.mathom.model;

import com.dan232.pricer.scraper.model.WebProductPrice;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Optional;
import java.util.regex.Pattern;

public class ScrapedGameFromGrid {

    private final Element game;

    public ScrapedGameFromGrid(final Element scrapedGame) {
        if (scrapedGame.is("div.product")) {
            this.game = scrapedGame;
        } else {
            var message = "This element is not the"
                    + " product the scraper is implemented for.";
            throw new RuntimeException(new IOException(message));
        }
    }

    /**
     * @return game name if found
     */
    public Optional<String> getName() {
        return Optional.ofNullable(game.selectFirst(".product-title"))
                .map(element -> element.selectFirst("a"))
                .map(Element::text)
                .map(name -> name.replaceAll("(?i)\\s*\\([^)]*"
                        + "(English|Inglés|Spanish|Español|Seminuevo|"
                        + "SEMINUEVO|Castellano|Multidioma)[^)]*\\)\\s*",
                        "").trim());
    }

    public Optional<String> getImage() {
        return Optional.ofNullable(game.selectFirst("img"))
                .map(element -> element.attribute("src"))
                .map(Attribute::getValue);
    }

    public Optional<Double> getPrice() {
        Pattern pattern = Pattern.compile("(\\d*),(\\d{2})");
        return Optional.ofNullable(game.selectFirst("span.price"))
                .map(Element::text)
                .flatMap(price -> {
                    var match = pattern.matcher(price);
                    if (match.find()) {
                        return Optional.of(
                                Double.parseDouble(
                                        match.group(1) + "." + match.group(2)));
                    } else {
                        return Optional.empty();
                    }
                });
    }

    public Optional<String> getDetailsURL() {
        return Optional.ofNullable(game.selectFirst("a"))
                .map(element -> element.attribute("href"))
                .map(Attribute::getValue);
    }

    /**
     * Transform scraped data to model.
     *
     * @return model representing scraped data
     */
    public Optional<WebProductPrice> toModel() {
        var nameOpt = getName();
        var priceOpt = getPrice();
        var urlOpt = getDetailsURL();
        var imageOpt = getImage();

        if (nameOpt.isEmpty() || priceOpt.isEmpty()
                || urlOpt.isEmpty() || imageOpt.isEmpty()) {
            return Optional.empty();
        }

        var name = nameOpt.get();
        double price = priceOpt.get();
        var url = urlOpt.get();
        var image = imageOpt.get();

        try {
            var pattern = Pattern.compile(".*-([^-]*)\\.html$");
            var matcher = pattern.matcher(url);
            if (!matcher.matches()) {
                return Optional.empty();
            }
            var ean = matcher.group(1);

            return Optional.of(new WebProductPrice(
                    ean,
                    name.replaceAll("(?i)\\s*\\((Inglés|"
                            + "CATALÀ|Español|Seminuevo|Castellano"
                            + "|Multidioma)\\)", "").trim(),
                    price,
                    URI.create(url).toURL(),
                    MathomUtils.sendPrice(price),
                    "MATHOM",
                    URI.create(image).toURL(),
                    null
            ));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
