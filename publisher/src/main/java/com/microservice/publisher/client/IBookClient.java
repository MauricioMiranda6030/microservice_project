package com.microservice.publisher.client;

import com.microservice.publisher.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "ebook", url = "localhost:9090/api/book")
public interface IBookClient {
    @GetMapping("/get/by/publisher/{id}")
    List<BookDTO> findAllBooksByPublisher(@PathVariable Long id);
}
