package com.example.librosYa.application.mappers.Book;

import com.example.librosYa.application.dto.request.BookRequest;

import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.domain.entities.BookEntity;
import com.example.librosYa.domain.entities.LoanEntity;
import com.example.librosYa.domain.entities.ReservationEntity;

import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookMapper {

    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    BookEntity toEntity(BookRequest bookRequest);

    @Mapping(target = "Author", ignore = true)
    @InheritInverseConfiguration
    BookResponse toResponse(BookEntity book);

    List<BookResponse> toGetBookList(List<BookEntity> bookList);

    List<BookEntity> toEntityList(List<BookRequest> bookRequestList);

    @Mapping(target = "loans", ignore = true)
    @Mapping(target = "reservations", ignore = true)
    void updateEntityFromDto(BookRequest dto, @MappingTarget BookEntity entity);

    
    default List<LoanEntity> mapLoans(List<LoanEntity> loans) {
        return loans;
    }

    
    default List<ReservationEntity> mapReservations(List<ReservationEntity> reservations) {
        return reservations;
    }
}


