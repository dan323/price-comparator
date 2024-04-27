package com.dan232.pricer.comparator.port;

import com.dan232.pricer.comparator.model.Category;

import java.util.Set;

public interface CategoryPort {

    Set<Category> getAllCategories();

    Category getRootCategory();
}
