package io.reeda.api.DTOs;

import io.reeda.api.enums.BookGenre;
import io.reeda.api.enums.BookType;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class BookDTO {
    private String title;
    private String author;
    private BookGenre bookGenre;
    private String isbn;
    private Integer numberOfCopies;
    private Date publicationDate;
    private String publisher;
    private String description;
    private BookType type;
}
