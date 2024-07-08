package com.example.librosYa.application.mappers.Reservation;


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
    Reservation toEntity (ReservationRequest reservationRequest);

    @InheritInverseConfiguration
    ReservationResponse toResponse (Reservation reservation);

    List<Reservation> toEntityList(List<ReservationRequest> request);

    List<ReservationResponse> toResponseList(List<Reservation> entity);

    void updateEntityFromDto(ReservationRequest dto, @MappingTarget Reservation entity);
}


