package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.domain.entities.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-23T19:46:58-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationResponse toGetDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationResponse reservationResponse = new ReservationResponse();

        return reservationResponse;
    }

    @Override
    public Reservation toEntity(ReservationRequest request) {
        if ( request == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.idReservation( request.getIdReservation() );
        reservation.status( request.getStatus() );

        return reservation.build();
    }

    @Override
    public List<ReservationResponse> toGetReservationList(List<Reservation> reservationList) {
        if ( reservationList == null ) {
            return null;
        }

        List<ReservationResponse> list = new ArrayList<ReservationResponse>( reservationList.size() );
        for ( Reservation reservation : reservationList ) {
            list.add( toGetDTO( reservation ) );
        }

        return list;
    }

    @Override
    public List<Reservation> toEntityList(List<ReservationRequest> reservationRequestList) {
        if ( reservationRequestList == null ) {
            return null;
        }

        List<Reservation> list = new ArrayList<Reservation>( reservationRequestList.size() );
        for ( ReservationRequest reservationRequest : reservationRequestList ) {
            list.add( toEntity( reservationRequest ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(ReservationRequest dto, Reservation entity) {
        if ( dto == null ) {
            return;
        }

        entity.setIdReservation( dto.getIdReservation() );
        entity.setReservationDate( dto.getReservationDate() );
        entity.setStatus( dto.getStatus() );
    }
}
