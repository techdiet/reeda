package io.reeda.api.services;

import io.reeda.api.DTOs.BookDTO;
import io.reeda.api.models.Book;
import io.reeda.api.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    public Book updateBook(Long id, BookDTO updatedBook) {
        Optional<Book> bookContainer = bookRepository.findById(id);

        if (bookContainer.isPresent()) {
            Book bookToUpdate = bookContainer.get();

            //Check and update non-null fields
            if (updatedBook.getTitle() != null) {
                bookToUpdate.setTitle(updatedBook.getTitle());
            }
            if (updatedBook.getAuthor() != null) {
                bookToUpdate.setAuthor(updatedBook.getAuthor());
            }
            if (updatedBook.getBookGenre() != null) {
                bookToUpdate.setBookGenre(updatedBook.getBookGenre());
            }
            if (updatedBook.getIsbn() != null) {
                bookToUpdate.setIsbn(updatedBook.getIsbn());
            }
            if (updatedBook.getNumberOfCopies() != null) {
                bookToUpdate.setNumberOfCopies(updatedBook.getNumberOfCopies());
            }
            if (updatedBook.getPublicationDate() != null) {
                bookToUpdate.setPublicationDate(updatedBook.getPublicationDate());
            }
            if (updatedBook.getPublisher()!= null) {
                bookToUpdate.setPublisher(updatedBook.getPublisher());
            }
            if (updatedBook.getDescription() != null) {
                bookToUpdate.setDescription(updatedBook.getDescription());
            }
            if (updatedBook.getType() != null) {
                bookToUpdate.setType(updatedBook.getType());
            }

            return bookRepository.save(bookToUpdate);
        } else {
            throw new IllegalArgumentException("Book with id: " + id + " not found!");
        }

    }

}
