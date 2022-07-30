package com.dan232.pricer.scrapper;

public interface ScrapWebsite {

    ScrapWebsites scrap();

    interface ScrapWebsites {
        void perform();
    }

}
