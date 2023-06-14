package io.reeda.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class BooksController {

    @GetMapping("/books")
    public String getBooks() {
        return "No books available yet";
    }
}
