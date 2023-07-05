package io.reeda.api.controllers;

import io.reeda.api.DTOs.BookDTO;
import io.reeda.api.models.Book;
import io.reeda.api.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Optional<Book>> searchByIsbn(@PathVariable String isbn){
        Optional<Book> book = bookService.searchByIsbn(isbn);
        return ResponseEntity.ok(book);
    }
}
