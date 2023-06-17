package io.reeda.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/welcome")
public class WelcomeController {
    @GetMapping
    public ResponseEntity<String> welcome() throws IOException {

        return new ResponseEntity<>("Welcome To  Reeda Your Dream Library Management App!", HttpStatus.OK);
    }
}
