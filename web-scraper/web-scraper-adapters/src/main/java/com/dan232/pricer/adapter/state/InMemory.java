package com.dan232.pricer.adapter.state;

import com.dan232.pricer.scraper.model.WebProductPrice;
import com.dan232.pricer.scraper.port.SavePort;

public class InMemory implements SavePort {

    @Override
    public WebProductPrice save(WebProductPrice webProductPrice) {
        return webProductPrice;
    }
}
