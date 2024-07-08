package com.example.librosYa.application.mappers.Reservation;


import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.domain.entities.ReservationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {
    ReservationEntity toEntity (ReservationRequest reservationRequest);

    @InheritInverseConfiguration
    ReservationResponse toResponse (ReservationEntity reservation);

    List<ReservationEntity> toEntityList(List<ReservationRequest> request);

    List<ReservationResponse> toResponseList(List<ReservationEntity> entity);

    void updateEntityFromDto(ReservationRequest dto, @MappingTarget ReservationEntity entity);
}


