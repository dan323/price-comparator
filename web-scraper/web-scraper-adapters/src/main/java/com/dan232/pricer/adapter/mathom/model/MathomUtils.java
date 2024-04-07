// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.mathom.model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class MathomUtils {

    private MathomUtils() {
        throw new UnsupportedOperationException("Cannot be instanced");
    }

    /**
     * From the doc of the grid page extract a stream
     * of elements representing the games.
     *
     * @param doc document created from the URL of a grid page
     * @return stream of elements representing games
     * @throws IOException in case the list of products cannot be found
     */
    static Stream<Element> getProductDataFromGridPage(final Document doc)
            throws IOException {
        var elms = doc.selectFirst("ul.product_list");
        if (elms == null) {
            throw new IOException("The product_list ul "
                    + "element could not be found");
        }
        return elms.select("li")
                .stream()
                .map(liElement -> liElement
                        .selectFirst("div.pro_second_box")
                );
    }

    /**
     * The MATHOM website has an error of a missing {@code "}
     * and the next attribute {@code itemtype}
     * has leaked into the URL.
     *
     * @param rawURL value of URL attribute scraped from website
     * @return actual URL wanted
     */
    static String urlExtractor(final String rawURL) {
        Pattern pattern = Pattern.compile("^(.*)\\sitemtype=$");
        var matcher = pattern.matcher(rawURL);
        if (matcher.matches()) {
            return matcher.toMatchResult().group(1);
        } else {
            var message = "The url extractor is not working for Mathom anymore";
            var exc = new IOException(message);
            throw new RuntimeException(exc);
        }

    }

    /**
     * Compute the delivery charge based on price.
     * @param price cost of the product
     * @return delivery cost to be paid in addition
     */
    public static double sendPrice(final double price) {
        if (price < 20) {
            return 5;
        } else if (price < 60) {
            return 3;
        } else {
            return 0;
        }
    }
}
