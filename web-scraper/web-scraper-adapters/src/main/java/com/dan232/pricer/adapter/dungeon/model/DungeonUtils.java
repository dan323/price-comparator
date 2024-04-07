// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.dungeon.model;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.stream.Stream;

public final class DungeonUtils {

    public static final double SEND_PRICE = 5.9;

    private DungeonUtils() {
        throw new UnsupportedOperationException("Cannot be instanced");
    }

    /**
     * From the doc of the grid page extract a stream
     * of elements representing the games.
     * @param doc document created from the URL of a grid page
     * @return stream of elements representing games
     */
    static Stream<Element> getProductDataFromGridPage(final Document doc) {
        return doc.select("article").stream();
    }
}
