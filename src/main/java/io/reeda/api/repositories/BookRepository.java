package io.reeda.api.repositories;

import io.reeda.api.models.Book;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findBookByTitle(@NonNull String title);
    Optional<Book> findBookByIsbn(String isbn);
}
