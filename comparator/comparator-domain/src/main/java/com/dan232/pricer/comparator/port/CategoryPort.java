// Copyright (c) 2025 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator.port;

import com.dan232.pricer.comparator.model.Category;

import java.util.Set;

public interface CategoryPort {

    Set<Category> getAllCategories();

    Category getRootCategory();
}
