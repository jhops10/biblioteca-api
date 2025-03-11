package com.jhops10.library_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar vazio.")
    @Column(nullable = false, length = 120)
    private String title;

    @NotBlank(message = "O autor não pode estar vazio.")
    @Column(nullable = false)
    private String author;

    @NotNull(message = "O ano de lançamento é obrigatório.")
    @Min(value = 1, message = "O ano de lançamento deve ser maior que 0.")
    @Column(nullable = false)
    private Integer releaseYear;

    @NotBlank(message = "A editora não pode estar vazia.")
    @Column(nullable = false)
    private String publisher;


    public Book() {
    }

    public Book(String title, String author, Integer releaseYear, String publisher) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.publisher = publisher;
    }



    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
