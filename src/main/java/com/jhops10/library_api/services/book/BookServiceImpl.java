package com.jhops10.library_api.services.book;

import com.jhops10.library_api.entities.Book;
import com.jhops10.library_api.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Book> bookForDelete = findById(id);
        if (bookForDelete.isPresent()) {
            bookRepository.deleteById(id);
        }
    }
}
