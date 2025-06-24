module web.scraper.domain {
    exports com.dan232.pricer.scraper.model;
    exports com.dan232.pricer.scraper.port;
    requires spring.context;
    opens com.dan232.pricer.scraper to spring.core, spring.beans, spring.context;
    exports com.dan232.pricer.scraper;
}