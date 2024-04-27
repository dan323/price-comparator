package com.dan232.pricer.adapter.db.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    String id;

    String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subcategory",
            joinColumns = @JoinColumn(name = "category"),
            inverseJoinColumns = @JoinColumn(name = "subcategory"))
    Set<Category> subCategories;


    @ManyToMany
    @JoinTable(
            name = "subcategory",
            joinColumns = @JoinColumn(name = "subcategory"),
            inverseJoinColumns = @JoinColumn(name = "category"))
    Set<Category> superCategories;

    public Category(){}

    public Category(String name) {
        this.name = name;
    }

    public void addSubCategory(Category subcategory) {
        subCategories.add(subcategory);
    }

    public String toString() {
        return "CAT{name=" + name + ";subs=" + subCategories.toString() + "}";
    }

}
