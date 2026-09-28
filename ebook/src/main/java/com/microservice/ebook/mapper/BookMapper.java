package com.microservice.ebook.mapper;

import com.microservice.ebook.dto.BookDTO;
import com.microservice.ebook.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper{
    Book toEntity(BookDTO dto);
    BookDTO toDto(Book book);
    List<BookDTO> toDtoList(List<Book> books);
    void updateEntity(
            BookDTO dto,
            @MappingTarget Book entity);
}
