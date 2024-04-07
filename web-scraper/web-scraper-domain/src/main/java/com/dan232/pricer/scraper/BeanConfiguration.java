package com.dan232.pricer.scraper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public ScrapWebsite scrapWebsite(List<ScraperPort> scrapers, SavePort savePort) {
        return () -> new ScrapUseCase(scrapers, savePort);
    }
}
