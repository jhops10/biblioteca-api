package com.jhops10.library_api.services.book;

import com.jhops10.library_api.entities.Book;
import com.jhops10.library_api.exceptions.BookNotFoundException;
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
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Livro com ID " + id + " não encontrado"));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        if(!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Não foi possível excluir: Livro com ID " + id + " não encontrado");
        }
        bookRepository.deleteById(id);
    }
}
