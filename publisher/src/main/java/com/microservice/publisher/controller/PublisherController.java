package com.microservice.publisher.controller;

import com.microservice.publisher.dto.PublisherDTO;
import com.microservice.publisher.dto.http.response.BookByPublisherResponse;
import com.microservice.publisher.service.IPublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    private final IPublisherService publisherService;

    public PublisherController(IPublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getPublisher(@PathVariable Long id){
        PublisherDTO dto = publisherService.getPublisher(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/get/all")
    ResponseEntity<?> getAllPublishers(){
        List<PublisherDTO> dtoList = publisherService.getAllPublishers();
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/get/books/{id}")
    ResponseEntity<?> getPublishersBooks(@PathVariable Long id){
        BookByPublisherResponse response = publisherService.findBooksByPublisherId(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/new")
    ResponseEntity<?> createPublisher(@RequestBody PublisherDTO publisherDTO){
        Long id = publisherService.createPublisher(publisherDTO);
        return ResponseEntity.created(URI.create("/api/publisher/get/"+id)).build();
   }

   @PutMapping("/edit/{id}")
   ResponseEntity<?> editPublisher(@RequestBody PublisherDTO dto, @PathVariable Long id){
        publisherService.editPublisher(dto, id);
        return ResponseEntity.ok().build();
   }

   @DeleteMapping("/delete/{id}")
   ResponseEntity<?> deletePublisher(@PathVariable Long id){
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
   }
}
