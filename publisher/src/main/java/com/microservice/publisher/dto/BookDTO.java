package com.microservice.publisher.dto;

import java.util.UUID;

public record BookDTO(
         Long id,
         String isbn,
         String name,
         String author,
         Double price,
         Integer stock,
         Long publisherId
) { }
