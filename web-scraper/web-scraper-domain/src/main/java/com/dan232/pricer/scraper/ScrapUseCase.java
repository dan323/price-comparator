// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper;

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
                        savePort.save(webProductPrice);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
