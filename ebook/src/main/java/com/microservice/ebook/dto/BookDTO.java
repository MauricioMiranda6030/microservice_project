package com.microservice.ebook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

public record BookDTO(UUID uuid,
                      @NotBlank(message = "ISBN cannot be blank")
                      String isbn,
                      @NotBlank(message = "Name cannot be blank")
                      String name,
                      @NotBlank(message = "Author cannot be blank")
                      String author,
                      @NotBlank(message = "Publisher cannot be blank")
                      String publisher,
                      @PositiveOrZero(message = "Price must be a positive or zero")
                      Double price,
                      @NotNull(message = "Stock must not be null")
                      @PositiveOrZero(message = "Stock must be a positive or zero")
                      Integer stock,
                      @NotNull(message = "Stock must not be null")
                      Long publisherId) {
}
