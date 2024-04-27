package com.dan232.pricer.comparator.model;

import java.util.Set;

public record Category(String name,
                       Set<Category> subcategories,
                       String description) {
}
