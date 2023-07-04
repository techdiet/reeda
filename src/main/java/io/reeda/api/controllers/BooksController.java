package io.reeda.api.controllers;

import io.reeda.api.DTOs.BookDTO;
import io.reeda.api.models.Book;
import io.reeda.api.services.BookService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookDTO updatedBook) {
        try {
            Book updated = bookService.updateBook(id, updatedBook);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
