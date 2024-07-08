package com.example.librosYa.infraestructure.abstract_services;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.infraestructure.abstract_services.generic.CreateService.*;
import org.springframework.stereotype.Service;

@Service
public interface IReservationService extends
        CreateService<ReservationRequest, ReservationResponse>,
        DeleteService<Long>,
        ReadAllService<ReservationResponse>,
        ReadService<ReservationResponse,Long>,
        UpdateService<ReservationRequest,ReservationResponse, Long> {
}
