package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.infraestructure.abstract_services.generic.CreateService.*;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IReservationService extends
        CreateService<ReservationRequest, ReservationResponse>,
        DeleteService<Long>,
        ReadAllService<ReservationResponse>,
        ReadService<ReservationResponse,Long>,
        UpdateService<ReservationRequest,ReservationResponse, Long> {

                List<ReservationResponse> getAllByUserId(Long userId);

                List<ReservationResponse> getAllByBookId(Long bookId); 
}
