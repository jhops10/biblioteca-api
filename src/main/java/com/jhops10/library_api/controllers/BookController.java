package com.jhops10.library_api.controllers;

import com.jhops10.library_api.dto.book.BookRequestDTO;
import com.jhops10.library_api.dto.book.BookResponseDTO;
import com.jhops10.library_api.entities.Book;
import com.jhops10.library_api.mappers.BookMapper;
import com.jhops10.library_api.services.book.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAll() {
        List<Book> books = bookService.findAll();
        List<BookResponseDTO> booksResponseDTO = books.stream().map(BookMapper::toDTO).toList();
        return ResponseEntity.ok(booksResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> findById(@PathVariable("id") Long id) {
        Book result = bookService.findById(id);
        BookResponseDTO response = BookMapper.toDTO(result);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> save(@Valid @RequestBody BookRequestDTO bookRequestDTO) {
        Book book = BookMapper.toEntity(bookRequestDTO);
        Book savedBook = bookService.save(book);
        BookResponseDTO response = BookMapper.toDTO(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
