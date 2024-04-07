// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.mathom.model;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.OptionalInt;
import java.util.regex.Pattern;

public class ScrapablePageableGridPage extends ScrapableGridPage {

    public ScrapablePageableGridPage(final Document document) {
        super(document);
    }

    /**
     * @return page number for this page if found
     */
    public OptionalInt getPageNumber() {
        if (super.getDocument().baseUri().contains("p=")) {
            var pattern = Pattern.compile(".*p=(\\d+)(\\D.*|)$");
            var matcher = pattern.matcher(getDocument().baseUri());
            if (matcher.matches()) {
                return OptionalInt.of(Integer.parseInt(matcher.group(1)));
            } else {
                var message =
                        "Something went wrong trying to get the page number";
                throw new RuntimeException(new IOException(message));
            }
        } else {
            return OptionalInt.empty();
        }
    }
}
