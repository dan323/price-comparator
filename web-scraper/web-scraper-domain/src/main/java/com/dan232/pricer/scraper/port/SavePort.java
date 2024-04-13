// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.port;

import com.dan232.pricer.scraper.model.WebProductPrice;

import java.io.IOException;

public interface SavePort {

    /**
     * Save to state.
     * @param webProductPrice model to save
     * @throws IOException in case the state could not be updated properly
     */
    WebProductPrice save(WebProductPrice webProductPrice) throws IOException;
}
