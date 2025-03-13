package com.jhops10.library_api.mappers;

import com.jhops10.library_api.dto.book.BookRequestDTO;
import com.jhops10.library_api.dto.book.BookResponseDTO;
import com.jhops10.library_api.entities.Book;

public class BookMapper {

    public static Book toEntity(BookRequestDTO request) {
        Book bookEntity = new Book();
        bookEntity.setTitle(request.getTitle());
        bookEntity.setAuthor(request.getAuthor());
        bookEntity.setReleaseYear(request.getReleaseYear());
        bookEntity.setPublisher(request.getPublisher());
        return bookEntity;
    }

    public static BookResponseDTO toDTO(Book book) {
        BookResponseDTO bookDTO = new BookResponseDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setReleaseYear(book.getReleaseYear());
        bookDTO.setPublisher(book.getPublisher());
        return bookDTO;

    }
}
