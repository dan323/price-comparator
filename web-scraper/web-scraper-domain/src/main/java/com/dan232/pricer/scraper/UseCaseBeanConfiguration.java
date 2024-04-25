package com.dan232.pricer.scraper;

import com.dan232.pricer.scraper.port.SavePort;
import com.dan232.pricer.scraper.port.ScrapWebsite;
import com.dan232.pricer.scraper.port.ScraperPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UseCaseBeanConfiguration {

    @Bean
    public ScrapWebsite scrapWebsite(List<ScraperPort> scrapers, SavePort savePort) {
        return () -> new ScrapUseCase(scrapers, savePort);
    }
}
