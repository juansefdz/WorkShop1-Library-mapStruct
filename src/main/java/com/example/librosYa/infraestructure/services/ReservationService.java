package com.example.librosYa.infraestructure.services;

import com.example.librosYa.api.dto.DtoReservation;
import com.example.librosYa.infraestructure.abstract_services.IReservationService;
import org.springframework.data.domain.Page;

public class ReservationService implements IReservationService {
    @Override
    public Page<DtoReservation> getAll(int page, int size) {
        return null;
    }

    @Override
    public DtoReservation getById(Long id) {
        return null;
    }

    @Override
    public DtoReservation create(DtoReservation dtoRequest) {
        return null;
    }

    @Override
    public DtoReservation update(DtoReservation dtoRequest, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
