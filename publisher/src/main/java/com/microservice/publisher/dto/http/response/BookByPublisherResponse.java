package com.microservice.publisher.dto.http.response;

import com.microservice.publisher.dto.BookDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record BookByPublisherResponse(
        String publisherName,
        List<BookDTO> books
) {
}
