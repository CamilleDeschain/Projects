package com.tw.CatalogBook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
public class BookVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(unique = true)
    private String nameVersion;
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("versions")
    private BookVersion bookVersion;
    @OneToMany(mappedBy = "version")
    @JsonIgnore
    private Set<Book> books = new HashSet<>();
}
