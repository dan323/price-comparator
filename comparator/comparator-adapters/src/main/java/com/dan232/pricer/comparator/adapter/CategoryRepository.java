package com.dan232.pricer.comparator.adapter;

import com.dan232.pricer.comparator.model.Category;
import com.dan232.pricer.comparator.port.CategoryPort;
import com.dan232.pricer.postgresql.CategoryRepo;

import java.util.Set;
import java.util.stream.Collectors;

public class CategoryRepository implements CategoryPort {

    private final CategoryRepo dbRepo;

    public CategoryRepository(CategoryRepo dbRepo){
        this.dbRepo = dbRepo;
    }

    @Override
    public Set<Category> getAllCategories() {
        return dbRepo.findAll().stream().map(this::toModel).collect(Collectors.toSet());
    }

    @Override
    public Category getRootCategory() {
        return new Category("root", dbRepo.topCategories().stream().map(this::toModel).collect(Collectors.toSet()),"Nodo padre");
    }

    /**
     * We are assuming that the categories form a tree, hence no loops
     */
    private Category toModel(com.dan232.pricer.postgresql.entity.Category category){
        return new Category(category.getName(), category.getSubCategories().stream().map(this::toModel).collect(Collectors.toSet()), category.getDescription());
    }
}
