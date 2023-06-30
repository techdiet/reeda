package io.reeda.api.services;

import io.reeda.api.repositories.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
