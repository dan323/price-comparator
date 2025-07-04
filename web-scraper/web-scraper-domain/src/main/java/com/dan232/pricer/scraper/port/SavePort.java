// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.port;

import com.dan232.pricer.scraper.model.WebProductPrice;

public interface SavePort {

    /**
     * Save to state.
     *
     * @param webProductPrice model to save
     * @return the object that was saved
     */
    WebProductPrice save(WebProductPrice webProductPrice);
}
