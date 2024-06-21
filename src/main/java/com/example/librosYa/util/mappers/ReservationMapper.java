package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoReservation;
import com.example.librosYa.domain.entities.Reservation;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {UserMapper.class,BookMapper.class})
public interface ReservationMapper {

    DtoReservation toGetDTO(Reservation reservation);

    @InheritInverseConfiguration
    Reservation toEntity(DtoReservation getReservation);
    List<DtoReservation> toGetReservationList (List<Reservation> reservationList);
    List<Reservation> toEntityList(List<DtoReservation> reservationRequestList);
}

