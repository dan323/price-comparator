module web.scraper.adapters {
    requires web.scraper.domain;
    requires org.jsoup;
    requires jakarta.cdi;
    requires jakarta.transaction;
    requires pricer.db;
    requires spring.context;

    opens com.dan232.pricer.adapter to  spring.core, spring.beans, spring.context;
}