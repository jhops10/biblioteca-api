package com.jhops10.library_api.services.book;

import com.jhops10.library_api.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
}
