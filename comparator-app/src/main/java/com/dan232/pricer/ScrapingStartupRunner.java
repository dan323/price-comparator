package com.dan232.pricer;

import com.dan232.pricer.scraper.port.ScrapWebsite;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class ScrapingStartupRunner implements ApplicationRunner {

    private final ScrapWebsite scrapUseCase;

    public ScrapingStartupRunner(ScrapWebsite scrapUseCase) {
        this.scrapUseCase = scrapUseCase;
    }

    @Override
    public void run(ApplicationArguments args) {
        scrapUseCase.scrap().perform();
        System.out.println("✅ Scraping completed on startup");
    }
}
