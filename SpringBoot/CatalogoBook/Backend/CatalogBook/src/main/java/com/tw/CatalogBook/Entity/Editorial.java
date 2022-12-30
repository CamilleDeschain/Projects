package com.tw.CatalogBook.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(unique = true)
    private String nameEditorial;
    @OneToMany(mappedBy = "editorial", fetch = FetchType.EAGER)
    private Set<BookVersion> bookVersions = new HashSet<>();
}