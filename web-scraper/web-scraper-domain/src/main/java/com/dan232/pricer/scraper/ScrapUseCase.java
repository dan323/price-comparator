// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper;

import com.dan232.pricer.scraper.port.SavePort;
import com.dan232.pricer.scraper.port.ScrapWebsite;
import com.dan232.pricer.scraper.port.ScraperPort;

import java.util.List;

public final class ScrapUseCase implements ScrapWebsite.ScrapWebsites {

    private final List<ScraperPort> scraperPorts;
    private final SavePort savePort;

    ScrapUseCase(final List<ScraperPort> scrapers, final SavePort memory) {
        this.scraperPorts = scrapers;
        this.savePort = memory;
    }

    @Override
    public void perform() {
        scraperPorts.parallelStream()
                .flatMap(port -> port.scrapWeb().stream())
                .filter(p -> EANUtil.validateEAN13(p.EAN()))
                .forEach(savePort::save);
    }
}
