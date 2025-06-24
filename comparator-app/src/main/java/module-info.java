module comparator.exec {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.beans;
    requires spring.core;
    requires java.sql;
    requires spring.data.jpa;
    requires pricer.db;

    opens com.dan232.pricer to spring.core, spring.beans, spring.context;
    requires web.scraper.adapters;
    requires web.scraper.domain;
    requires spring.context;
}