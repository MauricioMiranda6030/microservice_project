package com.microservice.ebook.exception;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Book with ID: " + id + " not found");
    }
}
