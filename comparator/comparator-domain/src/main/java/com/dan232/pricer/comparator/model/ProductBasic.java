// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator.model;

import java.net.URL;
import java.util.List;

public record ProductBasic(String name,
                           double minPrice,
                           List<String> categories,
                           URL image) {
}
