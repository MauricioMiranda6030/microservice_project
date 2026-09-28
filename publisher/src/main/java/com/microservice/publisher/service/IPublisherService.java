package com.microservice.publisher.service;

import com.microservice.publisher.dto.PublisherDTO;
import com.microservice.publisher.dto.http.response.BookByPublisherResponse;

import java.util.List;

public interface IPublisherService{
    Long createPublisher(PublisherDTO publisher);

    PublisherDTO getPublisher(Long id);

    List<PublisherDTO> getAllPublishers();

    void deletePublisher(Long id);

    void editPublisher(PublisherDTO publisher, Long id);

    BookByPublisherResponse findBooksByPublisherId(Long id);
}
