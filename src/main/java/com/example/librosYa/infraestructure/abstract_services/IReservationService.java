package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import org.springframework.stereotype.Service;

@Service
public interface IReservationService extends CRUDService<ReservationRequest, ReservationResponse,Long>{
}
