package com.example.librosYa.application.mappers.Reservation;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.domain.entities.BookEntity;
import com.example.librosYa.domain.entities.ReservationEntity;
import com.example.librosYa.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T18:22:41-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationEntity toEntity(ReservationRequest reservationRequest) {
        if ( reservationRequest == null ) {
            return null;
        }

        ReservationEntity.ReservationEntityBuilder reservationEntity = ReservationEntity.builder();

        reservationEntity.idReservation( reservationRequest.getIdReservation() );
        reservationEntity.status( reservationRequest.getStatus() );

        return reservationEntity.build();
    }

    @Override
    public ReservationResponse toResponse(ReservationEntity reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponse.ReservationResponseBuilder reservationResponse = ReservationResponse.builder();

        reservationResponse.book( bookEntityToBookResponse( reservation.getBook() ) );
        reservationResponse.idReservation( reservation.getIdReservation() );
        reservationResponse.status( reservation.getStatus() );
        reservationResponse.user( userEntityToUserResponse( reservation.getUser() ) );

        return reservationResponse.build();
    }

    @Override
    public List<ReservationEntity> toEntityList(List<ReservationRequest> request) {
        if ( request == null ) {
            return null;
        }

        List<ReservationEntity> list = new ArrayList<ReservationEntity>( request.size() );
        for ( ReservationRequest reservationRequest : request ) {
            list.add( toEntity( reservationRequest ) );
        }

        return list;
    }

    @Override
    public List<ReservationResponse> toResponseList(List<ReservationEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ReservationResponse> list = new ArrayList<ReservationResponse>( entity.size() );
        for ( ReservationEntity reservationEntity : entity ) {
            list.add( toResponse( reservationEntity ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(ReservationRequest dto, ReservationEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setIdReservation( dto.getIdReservation() );
        entity.setReservationDate( dto.getReservationDate() );
        entity.setStatus( dto.getStatus() );
    }

    protected BookResponse bookEntityToBookResponse(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse = BookResponse.builder();

        bookResponse.genre( bookEntity.getGenre() );
        bookResponse.idBook( bookEntity.getIdBook() );
        bookResponse.isbn( bookEntity.getIsbn() );
        bookResponse.publicationYear( bookEntity.getPublicationYear() );
        bookResponse.titleBook( bookEntity.getTitleBook() );

        return bookResponse.build();
    }

    protected UserResponse userEntityToUserResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.email( userEntity.getEmail() );
        userResponse.fullName( userEntity.getFullName() );
        if ( userEntity.getIdUser() != null ) {
            userResponse.idUser( userEntity.getIdUser() );
        }
        userResponse.role( userEntity.getRole() );
        userResponse.username( userEntity.getUsername() );

        return userResponse.build();
    }
}
