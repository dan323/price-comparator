// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.dungeon;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.stream.Stream;

public class DungeonUtils {
    public static Stream<Element> getProductDataFromGridPage(Document doc) {
        return doc.select("article").stream();
    }
}
