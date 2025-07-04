// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.dungeon.model;

import com.dan232.pricer.scraper.model.WebProductPrice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Optional;
import java.util.regex.Pattern;

import static com.dan232.pricer.adapter.dungeon.model.DungeonUtils.SEND_PRICE;

public class ScrapedGameFromGrid {

    private final Element game;

    public ScrapedGameFromGrid(final Element element) {
        this.game = element;
    }

    /**
     * Transform this scraped data to the model.
     *
     * @return the data as the model if possible
     */
    public Optional<WebProductPrice> toModel() {
        Optional<String> urlOpt = getDetailURL();
        Optional<ScrapedDetailGame> detailOpt = goTo();

        if (urlOpt.isEmpty() || detailOpt.isEmpty()) {
            return Optional.empty();
        }

        ScrapedDetailGame detail = detailOpt.get();
        Optional<String> nameOpt = detail.getName();
        Optional<String> eanOpt = detail.getEAN();
        Optional<String> imageOpt = detail.getImage();
        Optional<Double> priceOpt = getPrice();

        if (nameOpt.isEmpty() || eanOpt.isEmpty()
                || imageOpt.isEmpty() || priceOpt.isEmpty()) {
            return Optional.empty();
        }

        try {
            String name = nameOpt.get().replaceAll("(?i)\\s*\\"
                    + "((Inglés|CATALÀ|Español|Seminuevo|Castellano|"
                    + "Multidioma)\\)", "").trim();
            return Optional.of(new WebProductPrice(
                    eanOpt.get(),
                    name,
                    priceOpt.get(),
                    URI.create(urlOpt.get()).toURL(),
                    SEND_PRICE,
                    "DUNGEONS MARVEL",
                    URI.create(imageOpt.get()).toURL(),
                    null
            ));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private Optional<ScrapedDetailGame> goTo() {
        return getDetailURL().map(url -> {
            try {
                return new ScrapedDetailGame(Jsoup
                        .connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
                                + " AppleWebKit/537.36 (KHTML, like Gecko) "
                                + "Chrome/108.0.0.0 Safari/537.36")
                        .header("Accept-Language", "es-ES")
                        .get());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * @return url of the detailed product if possible
     */
    public Optional<String> getDetailURL() {
        return Optional.ofNullable(game.selectFirst("a"))
                .map(element -> element.attribute("href"))
                .map(Attribute::getValue);
    }

    /**
     * @return the price of the product if found
     */
    public Optional<Double> getPrice() {
        return Optional.ofNullable(game
                        .selectFirst("div.product-price-and-shipping"
                                + " span.price"))
                .map(Element::text)
                .map(value -> {
                    var pattern = Pattern.compile("(\\d+,\\d\\d)\\s.*");
                    var matcher = pattern.matcher(value);
                    if (matcher.matches()) {
                        return Double.parseDouble(matcher
                                .group(1).replace(",", ".")
                        );
                    } else {
                        throw new RuntimeException(
                                new IOException(
                                        "The price could not be parsed."
                                )
                        );
                    }
                });
    }
}
