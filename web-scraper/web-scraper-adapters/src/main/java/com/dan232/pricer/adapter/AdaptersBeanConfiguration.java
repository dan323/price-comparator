package com.dan232.pricer.adapter;

import com.dan232.pricer.adapter.dungeon.DungeonMarvelsOffersScraperAdapter;
import com.dan232.pricer.adapter.mathom.MathomNewGamesScraperAdapter;
import com.dan232.pricer.adapter.mathom.MathomOffersScraperAdapter;
import com.dan232.pricer.adapter.state.DBSave;
import com.dan232.pricer.adapter.state.NoOpSave;
import com.dan232.pricer.postgresql.PriceRepo;
import com.dan232.pricer.postgresql.ProductRepo;
import com.dan232.pricer.postgresql.ProductShopRepo;
import com.dan232.pricer.postgresql.ShopRepo;
import com.dan232.pricer.scraper.port.SavePort;
import com.dan232.pricer.scraper.port.ScraperPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdaptersBeanConfiguration {

    @Bean
    public SavePort port(ProductRepo productRepo, ShopRepo shopRepo, ProductShopRepo productShopRepo, PriceRepo priceRepo){
        return new DBSave(productRepo, shopRepo, productShopRepo, priceRepo);
    }
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
