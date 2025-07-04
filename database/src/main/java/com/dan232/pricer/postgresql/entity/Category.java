// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.postgresql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subcategory",
            joinColumns = @JoinColumn(name = "category"),
            inverseJoinColumns = @JoinColumn(name = "subcategory")
    )
    private Set<Category> subCategories;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subcategory",
            joinColumns = @JoinColumn(name = "subcategory"),
            inverseJoinColumns = @JoinColumn(name = "category")
    )
    private Category superCategory;

    public Category() {
    }

    public Category getSuperCategory() {
        return superCategory;
    }

    public String toString() {
        return "CAT{name=" + name
                + ";subs=" + subCategories.toString()
                + ";desc=" + description + "}";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Category> getSubCategories() {
        return Optional.ofNullable(subCategories)
                .orElse(new HashSet<>());
    }
}
