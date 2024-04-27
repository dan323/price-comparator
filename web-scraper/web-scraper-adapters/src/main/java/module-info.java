module web.scraper.adapters {
    requires spring.context;
    requires web.scraper.domain;
    requires org.jsoup;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires jakarta.validation;

    requires org.hibernate.orm.core;
    exports com.dan232.pricer.adapter.db.entity;
    opens com.dan232.pricer.adapter.db.entity;
    opens com.dan232.pricer.adapter to spring.core, spring.beans, spring.context;
}