package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.domain.entities.BookEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {
    BookResponse toGetDTO(BookEntity book);

    @InheritInverseConfiguration
    BookEntity toEntity(BookRequest request);

    List<BookResponse> toGetBookList(List<BookEntity> bookList);
    List<BookEntity> toEntityList(List<BookRequest> bookRequestList);

    void updateEntityFromDto(BookRequest dto, @MappingTarget BookEntity entity);
}


