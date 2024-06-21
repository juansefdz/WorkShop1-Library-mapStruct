package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoReservation;
import com.example.librosYa.domain.entities.Reservation;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, BookMapper.class})
public interface ReservationMapper {

    DtoReservation toGetDTO(Reservation reservation, @Context UserMapper userMapper, @Context BookMapper bookMapper);

    @InheritInverseConfiguration
    Reservation toEntity(DtoReservation getReservation, @Context UserMapper userMapper, @Context BookMapper bookMapper);

    List<DtoReservation> toGetReservationList(List<Reservation> reservationList, @Context UserMapper userMapper, @Context BookMapper bookMapper);

    List<Reservation> toEntityList(List<DtoReservation> reservationRequestList, @Context UserMapper userMapper, @Context BookMapper bookMapper);
}

