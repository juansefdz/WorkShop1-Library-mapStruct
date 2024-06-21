package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoBook;
import com.example.librosYa.domain.entities.BookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {ReservationMapper.class,LoanMapper.class})
public interface BookMapper {

    @Mapping(source = "idBook",target = "idBook")
    DtoBook toGetDTO(BookEntity book);

    @InheritInverseConfiguration
    BookEntity toEntity(DtoBook getBook);
    List<DtoBook> toGetBookList (List<BookEntity> bookEntityList);
    List<BookEntity> toEntityList(List<DtoBook> bookRequestList);
}

