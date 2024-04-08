// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper;

import com.dan232.pricer.scraper.port.SavePort;
import com.dan232.pricer.scraper.port.ScrapWebsite;
import com.dan232.pricer.scraper.port.ScraperPort;

import java.io.IOException;
import java.util.List;

final class ScrapUseCase implements ScrapWebsite.ScrapWebsites {

    private final List<ScraperPort> scraperPorts;
    private final SavePort savePort;

    ScrapUseCase(final List<ScraperPort> scrapers, final SavePort memory) {
        this.scraperPorts = scrapers;
        this.savePort = memory;
    }


    @Override
    public void perform() {
        scraperPorts.stream()
                .flatMap(port -> port.scrapWeb().stream())
                .forEach(webProductPrice -> {
                    try {
                        if (EANUtil.validateEAN13(webProductPrice.EAN())) {
                            savePort.save(webProductPrice);
                        } else {
                            throw new IOException(
                                    "The EAN number read is not such"
                            );
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
