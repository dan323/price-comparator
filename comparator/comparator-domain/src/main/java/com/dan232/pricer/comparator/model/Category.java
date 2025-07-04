// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator.model;

import java.util.Set;

public record Category(String name,
                       Set<Category> subcategories,
                       String description) {
}
