package com.jhops10.library_api.services.book;

import com.jhops10.library_api.entities.Book;
import com.jhops10.library_api.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void testFindById_ExistingBook() {
        Long bookId = 1L;
        Book book = new Book("Title", "Author", 2025, "Publisher");
        book.setId(bookId);

        when(bookRepository.findById(bookId)).thenReturn(java.util.Optional.of(book));

        Optional<Book> result = bookService.findById(bookId);

        assertTrue(result.isPresent());
        assertEquals(bookId, result.get().getId());
        assertEquals("Title", result.get().getTitle());
        assertEquals("Author", result.get().getAuthor());
        assertEquals(2025, result.get().getReleaseYear());
        assertEquals("Publisher", result.get().getPublisher());

        verify(bookRepository, times(1)).findById(bookId);

    }

    @Test
    public void testFindById_BookNotFound() {
        Long bookId = 1L;

        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        Optional<Book> result = bookService.findById(bookId);

        assertFalse(result.isPresent());

        verify(bookRepository, times(1)).findById(bookId);


    }

    @Test
    public void testSaveBook() {
        Book book = new Book("Title", "Author", 2025, "Publisher");

        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.save(book);

        assertEquals("Title", savedBook.getTitle());
        assertEquals("Author", savedBook.getAuthor());
        assertEquals(2025, savedBook.getReleaseYear());
        assertEquals("Publisher", savedBook.getPublisher());

        verify(bookRepository, times(1)).save(book);

    }

    @Test
    public void testDeleteById() {
        Long bookId = 1L;

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book()));

        bookService.deleteById(bookId);

        verify(bookRepository, times(1)).deleteById(bookId);
    }


    @Test
    public void testDeleteById_BookNotFound() {
        Long bookId = 1L;

        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        bookService.deleteById(bookId);

        verify(bookRepository, never()).deleteById(bookId);
    }
}
