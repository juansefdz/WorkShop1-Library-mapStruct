package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoBook;
import com.example.librosYa.domain.entities.BookEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(source = "idBook", target = "idBook")
    DtoBook toGetDTO(BookEntity book);

    @InheritInverseConfiguration
    BookEntity toEntity(DtoBook getBook);

    List<DtoBook> toGetBookList(List<BookEntity> bookEntityList);

    List<BookEntity> toEntityList(List<DtoBook> bookRequestList);
}


