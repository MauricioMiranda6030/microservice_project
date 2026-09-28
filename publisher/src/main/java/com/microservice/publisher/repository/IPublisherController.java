package com.microservice.publisher.repository;

import com.microservice.publisher.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IPublisherController extends JpaRepository<Publisher, Long> {
}
