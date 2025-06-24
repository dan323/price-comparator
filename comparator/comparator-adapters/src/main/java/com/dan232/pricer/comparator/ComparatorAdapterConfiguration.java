package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.adapter.CategoryRepository;
import com.dan232.pricer.comparator.adapter.ProductRepository;
import com.dan232.pricer.comparator.port.CategoryPort;
import com.dan232.pricer.comparator.port.ProductPort;
import com.dan232.pricer.postgresql.CategoryRepo;
import com.dan232.pricer.postgresql.PriceRepo;
import com.dan232.pricer.postgresql.ProductRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComparatorAdapterConfiguration {

    @Bean
    CategoryPort categoryPort(CategoryRepo dbRepo){
        return new CategoryRepository(dbRepo);
    }

    @Bean
    ProductPort productPort(PriceRepo priceRepo, ProductRepo productRepo) {
        return new ProductRepository(productRepo, priceRepo);
    }
}
