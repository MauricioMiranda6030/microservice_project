package com.microservice.ebook.service;

import com.microservice.ebook.dto.BookDTO;

import java.util.List;
import java.util.UUID;

public interface IBookService {

    Long createBook(BookDTO dto);

    BookDTO findBook(Long id);

    List<BookDTO> findAllBooks();

    void updateBook(BookDTO dto, Long id);

    void deleteBook(Long id);

    List<BookDTO> getBooksByPublisher(Long publisherIdd);
}
