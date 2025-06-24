// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Pattern(regexp = "(?i)\\b((?:[a-z][\\w-]+:(?:/{1,3}|[a-z0-9%])|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:'\".,<>?«»“”‘’]))")
    private String homesite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getHomesite() {
        return homesite;
    }

    public String toString() {
        return "SHOP{name=" + name + ";home=" + homesite + "}";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHomesite(String homesite) {
        this.homesite = homesite;
    }
}
