package com.tw.CatalogBook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tw.CatalogBook.Enum.Cover;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String edition;
    private boolean change;
    @Enumerated(EnumType.STRING)
    private Cover cover;
    @Min(10)
    private int pages;
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("books")
    private BookVersion bookVersion;
}