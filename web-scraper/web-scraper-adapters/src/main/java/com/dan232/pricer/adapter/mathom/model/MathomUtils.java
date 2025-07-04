// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.mathom.model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
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
        var elms = doc.selectFirst("div.products");
        if (elms == null) {
            throw new IOException("The product_list ul element"
                    + " could not be found");
        }
        return elms.select("div.product").stream();
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
