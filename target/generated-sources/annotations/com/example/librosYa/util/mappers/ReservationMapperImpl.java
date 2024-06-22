package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoReservation;
import com.example.librosYa.domain.entities.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T19:10:56-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public DtoReservation toGetDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        DtoReservation.DtoReservationBuilder dtoReservation = DtoReservation.builder();

        dtoReservation.idReservation( reservation.getIdReservation() );
        dtoReservation.status( reservation.getStatus() );

        return dtoReservation.build();
    }

    @Override
    public Reservation toEntity(DtoReservation getReservation) {
        if ( getReservation == null ) {
            return null;
        }

        Reservation.ReservationBuilder reservation = Reservation.builder();

        reservation.idReservation( getReservation.getIdReservation() );
        reservation.status( getReservation.getStatus() );

        return reservation.build();
    }

    @Override
    public List<DtoReservation> toGetReservationList(List<Reservation> reservationList) {
        if ( reservationList == null ) {
            return null;
        }

        List<DtoReservation> list = new ArrayList<DtoReservation>( reservationList.size() );
        for ( Reservation reservation : reservationList ) {
            list.add( toGetDTO( reservation ) );
        }

        return list;
    }

    @Override
    public List<Reservation> toEntityList(List<DtoReservation> reservationRequestList) {
        if ( reservationRequestList == null ) {
            return null;
        }

        List<Reservation> list = new ArrayList<Reservation>( reservationRequestList.size() );
        for ( DtoReservation dtoReservation : reservationRequestList ) {
            list.add( toEntity( dtoReservation ) );
        }

        return list;
    }
}