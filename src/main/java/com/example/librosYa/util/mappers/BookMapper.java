package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoBook;
import com.example.librosYa.domain.entities.BookEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ReservationMapper.class, LoanMapper.class})
public interface BookMapper {

    @Mapping(source = "idBook", target = "idBook")
    DtoBook toGetDTO(BookEntity book, @Context ReservationMapper reservationMapper, @Context LoanMapper loanMapper);

    @InheritInverseConfiguration
    BookEntity toEntity(DtoBook getBook, @Context ReservationMapper reservationMapper, @Context LoanMapper loanMapper);

    List<DtoBook> toGetBookList(List<BookEntity> bookEntityList, @Context ReservationMapper reservationMapper, @Context LoanMapper loanMapper);

    List<BookEntity> toEntityList(List<DtoBook> bookRequestList, @Context ReservationMapper reservationMapper, @Context LoanMapper loanMapper);
}


