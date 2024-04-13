package com.dan232.pricer.adapter;

import com.dan232.pricer.adapter.dungeon.DungeonMarvelsOffersScraperAdapter;
import com.dan232.pricer.adapter.mathom.MathomNewGamesScraperAdapter;
import com.dan232.pricer.adapter.mathom.MathomOffersScraperAdapter;
import com.dan232.pricer.scraper.port.SavePort;
import com.dan232.pricer.scraper.port.ScraperPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ScraperPort mathomOffers(){
        return new MathomOffersScraperAdapter();
    }
    @Bean
    public ScraperPort mathomNew(){
        return new MathomNewGamesScraperAdapter();
    }
    @Bean
    public ScraperPort dungeon(){
        return new DungeonMarvelsOffersScraperAdapter();
    }
}
