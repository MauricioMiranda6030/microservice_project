package com.microservice.ebook.service.imp;

import com.microservice.ebook.dto.BookDTO;
import com.microservice.ebook.exception.BookNotFoundException;
import com.microservice.ebook.mapper.BookMapper;
import com.microservice.ebook.entity.Book;
import com.microservice.ebook.repository.IBookRepository;
import com.microservice.ebook.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService implements IBookService {

    private final IBookRepository booksRepository;
    private final BookMapper mapper;

    BookService(IBookRepository bookRepository, BookMapper mapper) {
        this.booksRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public Long createBook(BookDTO dto) {
        Book book = mapper.toEntity(dto);
        return booksRepository.save(book).getId();
    }

    @Override
    public BookDTO findBook(Long id) {
        Book book = booksRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return mapper.toDto(book);
    }

    @Override
    public List<BookDTO> findAllBooks() {
        List<Book> books = booksRepository.findAll();
        return mapper.toDtoList(books);
    }

    @Override
    public void updateBook(BookDTO dto, Long id) {
        Book book = booksRepository.findById(id).orElseThrow();
        mapper.updateEntity(dto, book);
        booksRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        findBook(id);
        booksRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> getBooksByPublisher(Long publisherId) {
        return mapper.toDtoList(booksRepository.findBooksByPublisherId(publisherId));
    }
}
