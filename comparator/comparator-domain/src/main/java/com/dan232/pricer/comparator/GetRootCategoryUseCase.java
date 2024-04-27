// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.comparator;

import com.dan232.pricer.comparator.model.Category;
import com.dan232.pricer.comparator.port.CategoryPort;
import com.dan232.pricer.comparator.port.CategoryQueryUseCase;

final class GetRootCategoryUseCase implements CategoryQueryUseCase.GetRootCategory {

    private final CategoryPort categoryPort;

    GetRootCategoryUseCase(CategoryPort categoryPort){
        this.categoryPort = categoryPort;
    }

    @Override
    public Category perform() {
        return categoryPort.getRootCategory();
    }

}
