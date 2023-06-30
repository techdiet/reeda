package io.reeda.api.models;

import io.reeda.api.enums.BookGenre;
import io.reeda.api.enums.BookType;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="book")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class Book {
    @Id
    @SequenceGenerator(name = "BooKSequence", sequenceName = "BooKSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BooKSequence")
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    @Enumerated(EnumType.STRING)
    private BookGenre bookGenre;
    @NonNull
    @Enumerated(EnumType.STRING)
    private BookType type;
    @Nullable
    private String isbn;
    private Integer numberOfCopies;
    @Nullable
    private Date publicationDate;
    @Nullable
    private String publisher;
    @Nullable
    private String description;


    public Book(@NonNull String title, @NonNull BookGenre bookGenre, @NonNull BookType type) {
        this.title = title;
        this.bookGenre = bookGenre;
        this.type = type;
    }
}

