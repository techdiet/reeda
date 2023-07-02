package io.reeda.api.services;

import io.reeda.api.models.Book;
import io.reeda.api.repositories.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addbook(Book book) {
        return bookRepository.save(book);
    }

}
