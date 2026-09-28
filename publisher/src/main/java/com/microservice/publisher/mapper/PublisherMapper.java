package com.microservice.publisher.mapper;


import com.microservice.publisher.dto.PublisherDTO;
import com.microservice.publisher.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toEntity(PublisherDTO dto);
    PublisherDTO toDTO(Publisher publisher);
    List<PublisherDTO> toDTOList(List<Publisher> publishers);
    void updateEntity(
            PublisherDTO dto,
            @MappingTarget Publisher publisher
    );

}
 