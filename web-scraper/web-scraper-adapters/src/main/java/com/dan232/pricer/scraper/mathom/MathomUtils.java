// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.mathom;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MathomUtils {

    public static Stream<Element> getProductDataFromGridPage(Document doc) throws IOException {
        var elms = doc.selectFirst("ul.product_list");
        if (elms == null) {
            throw new IOException("The product_list ul element could not be found");
        }
        return elms.select("li")
                .stream()
                .map(liElement -> liElement.selectFirst("div.pro_second_box"));
    }

    public static String urlExtractor(String rawURL) {
        Pattern pattern = Pattern.compile("^(.*)\\sitemtype=$");
        var matcher = pattern.matcher(rawURL);
        if (matcher.matches()) {
            return matcher.toMatchResult().group(1);
        } else {
            var exc = new IOException("The url extractor is not working for Mathom anymore");
            throw new RuntimeException(exc);
        }

    }

    public static double sendPrice(double price) {
        if (price < 20) {
            return 5;
        } else if (price < 60) {
            return 3;
        } else {
            return 0;
        }
    }
}
