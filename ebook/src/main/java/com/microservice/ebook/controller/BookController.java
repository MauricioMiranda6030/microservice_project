package com.microservice.ebook.controller;

import com.microservice.ebook.dto.BookDTO;
import com.microservice.ebook.service.IBookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final IBookService bookService;

    BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getBook(@PathVariable Long id) {
        BookDTO book = bookService.findBook(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/get/all")
    ResponseEntity<?> getAllBooks() {
        List<BookDTO> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/get/by/publisher/{id}")
    ResponseEntity<?> getAllBooksByPublisher(@PathVariable Long id){
        List<BookDTO> books = bookService.getBooksByPublisher(id);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/new")
    ResponseEntity<?> createBook(@Valid @RequestBody BookDTO dto) {
        Long idCreated = bookService.createBook(dto);
        URI uri = URI.create(
                "/api/books/"
                        .concat(idCreated.toString()));
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/edit/{id}")
    ResponseEntity<?> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO dto) {
        bookService.updateBook(dto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
