// Copyright (c) 2022 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper;

public interface ScrapWebsite {

    ScrapWebsites scrap();

    interface ScrapWebsites {
        void perform();
    }

}
