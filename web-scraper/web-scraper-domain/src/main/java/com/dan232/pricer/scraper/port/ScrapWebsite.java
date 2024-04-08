// Copyright (c) 2022-2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.port;

public interface ScrapWebsite {

    /**
     * Create a use case action to scrap websites.
     * @return a use case action
     */
    ScrapWebsites scrap();

    interface ScrapWebsites {
        /**
         * Perform the scraping action.
         */
        void perform();
    }

}
