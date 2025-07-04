// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator.model;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;

public record ProductBasic(String name,
                           BigInteger ean,
                           double minPrice,
                           List<String> categories,
                           URL image) {
}
