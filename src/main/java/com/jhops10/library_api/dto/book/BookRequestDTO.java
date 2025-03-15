package com.jhops10.library_api.dto.book;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequestDTO {

    @NotBlank(message = "O título não pode estar vazio.")
    private String title;

    @NotBlank(message = "O autor não pode estar vazio.")
    private String author;

    @NotNull(message = "O ano de lançamento é obrigatório.")
    @Min(value = 1, message = "O ano de lançamento deve ser maior que 0.")
    private Integer releaseYear;

    @NotBlank(message = "A editora não pode estar vazia.")
    private String publisher;

    public BookRequestDTO() {
    }

    public BookRequestDTO(String title, String author, Integer releaseYear, String publisher) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.publisher = publisher;
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
