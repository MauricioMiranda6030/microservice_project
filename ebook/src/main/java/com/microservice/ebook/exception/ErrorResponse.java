package com.microservice.ebook.exception;

import java.time.LocalDateTime;

public record ErrorResponse(int status,
                            String error,
                            String description,
                            String path,
                            LocalDateTime time) {
}
