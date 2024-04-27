// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.port.CategoryPort;
import com.dan232.pricer.comparator.port.CategoryQueryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComparatorUseCaseConfiguration {

    @Bean
    CategoryQueryUseCase useCase(CategoryPort categoryPort){
        return new CategoryQueryUseCase() {
            @Override
            public GetRootCategory getRoot() {
                return new GetRootCategoryUseCase(categoryPort);
            }

            @Override
            public GetCategory getCategory(String id) {
                return new GetCategoryUseCase(categoryPort, id);
            }
        };
    }
}
