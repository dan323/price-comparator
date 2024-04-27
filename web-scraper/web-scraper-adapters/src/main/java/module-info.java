module web.scraper.adapters {
    requires spring.context;
    requires web.scraper.domain;
    requires org.jsoup;

    opens com.dan232.pricer.adapter to spring.core, spring.beans, spring.context;
}