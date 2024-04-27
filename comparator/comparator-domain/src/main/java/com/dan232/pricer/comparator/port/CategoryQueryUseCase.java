package com.dan232.pricer.comparator.port;

import com.dan232.pricer.comparator.model.Category;

import java.util.Optional;

public interface CategoryQueryUseCase {

    GetRootCategory getRoot();

    GetCategory getCategory(String id);

    interface GetRootCategory {
        Category perform();
    }

    interface GetCategory {
        Optional<Category> perform();
    }
}
