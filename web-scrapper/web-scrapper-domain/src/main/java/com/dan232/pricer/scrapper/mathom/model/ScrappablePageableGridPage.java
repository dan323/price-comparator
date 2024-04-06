// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scrapper.mathom.model;

import org.jsoup.nodes.Document;

import java.util.OptionalInt;
import java.util.regex.Pattern;

public class ScrappablePageableGridPage extends ScrappableGridPage{

    public ScrappablePageableGridPage(Document document) {
        super(document);
    }

    public OptionalInt getPageNumber(){
        if (super.document.baseUri().contains("p=")){
            var pattern = Pattern.compile(".*p=(\\d+)(\\D.*|)$");
            var matcher = pattern.matcher(document.baseUri());
            if (matcher.matches()){
                return OptionalInt.of(Integer.parseInt(matcher.group(1)));
            } else {
                throw new RuntimeException("Something went wrong trying to get the page number");
            }
        } else {
            return OptionalInt.empty();
        }
    }
}
