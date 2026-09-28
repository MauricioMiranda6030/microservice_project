package com.microservice.publisher.dto;

import java.util.UUID;

public record PublisherDTO(
        String name,
        String address,
        String country
) {
}
