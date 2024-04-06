// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.scraper.model;

import java.net.URL;

public record WebProductPrice(String id,
                              String productName,
                              double price,
                              URL homeSite,
                              double sendPrice) {

}
