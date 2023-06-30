//package io.reeda.api.services;
//
//import io.reeda.api.DTOs.BookDTO;
//import io.reeda.api.models.Book;
//import io.reeda.api.repositories.BookRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.*;
//
//public class BookServiceTest {
//
//    @Mock
//    private BookRepository bookRepository;
//
//    private BookService bookService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        bookService = new BookService(bookRepository);
//    }
//
//    @Test
//    public void testAddBook() {
//        BookDTO bookDTO = new BookDTO();
//        bookDTO.setTitle("Test Book");
//        // Set other properties of the bookDTO
//
//        ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
//        when(bookRepository.save(bookCaptor.capture())).thenReturn(new Book());
//
//        Book addedBook = bookService.addBook(bookDTO);
//
//        verify(bookRepository, times(1)).save(any(Book.class));
//        Book capturedBook = bookCaptor.getValue();
//        Assertions.assertEquals("Test Book", capturedBook.getTitle());
//        // Verify other properties of the captured book
//    }
//
//    @Test
//    public void testGetBooks() {
//        Book book1 = new Book();
//        book1.setTitle("Book 1");
//        Book book2 = new Book();
//        book2.setTitle("Book 2");
//        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));
//
//        List<Book> books = bookService.getBooks();
//
//        verify(bookRepository, times(1)).findAll();
//        Assertions.assertEquals(2, books.size());
//        // Verify other assertions about the returned books
//    }
//
//    @Test
//    public void testGetBook() {
//        Long bookId = 1L;
//        Book book = new Book();
//        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
//
//        Optional<Book> optionalBook = bookService.getBook(bookId);
//
//        verify(bookRepository, times(1)).findById(bookId);
//        Assertions.assertTrue(optionalBook.isPresent());
//        Assertions.assertSame(book, optionalBook.get());
//    }
//
//    @Test
//    public void testDeleteBook() {
//        Long bookId = 1L;
//        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book()));
//
//        bookService.deleteBook(bookId);
//
//        verify(bookRepository, times(1)).deleteById(bookId);
//    }
//
//    @Test
//    public void testDeleteBook_NotFound() {
//        Long bookId = 1L;
//        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());
//
//        Assertions.assertThrows(EntityNotFoundException.class, () -> bookService.deleteBook(bookId));
//
//        verify(bookRepository, never()).deleteById(bookId);
//    }
//
//    @Test
//    public void testUpdateBook() {
//        Long bookId = 1L;
//        BookDTO updatedBookDTO = new BookDTO();
//        updatedBookDTO.setTitle("Updated Book");
//
//        Book existingBook = new Book();
//        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
//        when(bookRepository.save(any(Book.class))).thenReturn(existingBook);
//
//        Book updatedBook = bookService.updateBook(bookId, updatedBookDTO);
//
//        verify(bookRepository, times(1)).findById(bookId);
//        verify(bookRepository, times(1)).save(existingBook);
//        Assertions.assertEquals("Updated Book", updatedBook.getTitle());
//        // Verify other assertions about the updated book
//    }
//
//    @Test
//    public void testUpdateBook_NotFound() {
//        Long bookId = 1L;
//        BookDTO updatedBookDTO = new BookDTO();
//
//        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());
//
//        Assertions.assertThrows(EntityNotFoundException.class, () -> bookService.updateBook(bookId, updatedBookDTO));
//
//        verify(bookRepository, never()).save(any(Book.class));
//    }
//}
