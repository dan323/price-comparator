// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer;

import com.dan232.pricer.postgresql.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class Application {

    @Autowired
    JpaRepository<Category, String> categoryStringJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> categoryStringJpaRepository.findAll().forEach(category ->
                System.out.println(category.toString()));
    }

}
