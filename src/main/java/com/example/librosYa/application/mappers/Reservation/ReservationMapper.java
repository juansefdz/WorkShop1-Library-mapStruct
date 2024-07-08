package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.domain.entities.Reservation;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    ReservationResponse toGetDTO(Reservation reservation);

    @InheritInverseConfiguration
    Reservation toEntity(ReservationRequest request);

    List<ReservationResponse> toGetReservationList(List<Reservation> reservationList);
    List<Reservation> toEntityList(List<ReservationRequest> reservationRequestList);

    void updateEntityFromDto(ReservationRequest dto, @MappingTarget Reservation entity);
}


