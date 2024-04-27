package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.adapter.CategoryRepository;
import com.dan232.pricer.comparator.port.CategoryPort;
import com.dan232.pricer.postgresql.CategoryRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComparatorAdapterConfiguration {

    @Bean
    CategoryPort categoryPort(CategoryRepo dbRepo){
        return new CategoryRepository(dbRepo);
    }
}
