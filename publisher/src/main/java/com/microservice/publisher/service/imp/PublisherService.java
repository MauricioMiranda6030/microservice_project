package com.microservice.publisher.service.imp;

import com.microservice.publisher.client.IBookClient;
import com.microservice.publisher.dto.BookDTO;
import com.microservice.publisher.dto.PublisherDTO;
import com.microservice.publisher.dto.http.response.BookByPublisherResponse;
import com.microservice.publisher.entity.Publisher;
import com.microservice.publisher.mapper.PublisherMapper;
import com.microservice.publisher.repository.IPublisherController;
import com.microservice.publisher.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService implements IPublisherService {

    private final IPublisherController publisherController;
    private final PublisherMapper mapper;
    private final IBookClient bookClient;

    @Autowired
    public PublisherService(IPublisherController pController, PublisherMapper mapper, IBookClient bookClient){
        this.publisherController = pController;
        this.mapper = mapper;
        this.bookClient = bookClient;
    }

    @Override
    public Long createPublisher(PublisherDTO publisher) {
        Publisher toSave = mapper.toEntity(publisher);
        return publisherController.save(toSave).getId();
    }

    @Override
    public PublisherDTO getPublisher(Long id) {
        Publisher publisherFound = publisherController.findById(id).orElseThrow();
        return mapper.toDTO(publisherFound);
    }

    @Override
    public List<PublisherDTO> getAllPublishers() {
        return mapper.toDTOList(publisherController.findAll());
    }

    @Override
    public void deletePublisher(Long id) {
        publisherController.deleteById(id);
    }

    @Override
    public void editPublisher(PublisherDTO publisher, Long id) {
        Publisher toUpdate = publisherController.findById(id).orElseThrow();
        mapper.updateEntity(publisher, toUpdate);

        publisherController.save(toUpdate);
    }

    @Override
    public BookByPublisherResponse findBooksByPublisherId(Long id) {
        Publisher publisher = publisherController.findById(id).orElseThrow();
        List<BookDTO> books = bookClient.findAllBooksByPublisher(id);

        return BookByPublisherResponse.builder()
                .publisherName(publisher.getName())
                .books(books)
                .build();
    }
}
