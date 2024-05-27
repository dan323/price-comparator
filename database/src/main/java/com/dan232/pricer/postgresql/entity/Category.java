// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private String id;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subcategory",
            joinColumns = @JoinColumn(name = "category"),
            inverseJoinColumns = @JoinColumn(name = "subcategory"))
    private Set<Category> subCategories;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subcategory",
            joinColumns = @JoinColumn(name = "subcategory"),
            inverseJoinColumns = @JoinColumn(name = "category"))
    private Set<Category> superCategories;

    public Category(){}

    public Set<Category> getSuperCategories(){
        return superCategories;
    }

    public String toString() {
        return "CAT{name=" + name + ";subs=" + subCategories.toString() + ";desc=" + description + "}";
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Set<Category> getSubCategories(){
        return subCategories;
    }
}
