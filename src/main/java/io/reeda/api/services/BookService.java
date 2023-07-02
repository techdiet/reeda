package io.reeda.api.services;

import io.reeda.api.models.Book;
import io.reeda.api.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Method to find a book by id
    public Optional<Book> getSingleBook(long id) {
        Optional<Book> bookContainer = bookRepository.findById(id);
        if (bookContainer.isPresent()) {
            return  bookContainer;
        } else {
            throw new IllegalArgumentException("Book not found: " + id);
        }
    }
}
