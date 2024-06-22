package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.application.mappers.ReservationMapper;
import com.example.librosYa.domain.entities.Reservation;
import com.example.librosYa.domain.repositories.ReservationRepository;
import com.example.librosYa.infraestructure.abstract_services.CRUDService;
import com.example.librosYa.infraestructure.abstract_services.IReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public Page<ReservationResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return reservationRepository.findAll(pagination).map(reservationMapper::toGetDTO);
    }

    @Override
    public ReservationResponse getById(Long id) {
        Reservation reservationEntity = find(id);
        return reservationMapper.toGetDTO(reservationEntity);
    }

    @Override
    public ReservationResponse create(ReservationRequest reservationRequest) {
        Reservation reservationEntity = reservationMapper.toEntity(reservationRequest);
        Reservation savedReservation = reservationRepository.save(reservationEntity);
        return reservationMapper.toGetDTO(savedReservation);
    }

    @Override
    public ReservationResponse update(ReservationRequest reservationRequest, Long id) {
        Reservation reservationEntity = find(id);
        reservationMapper.updateEntityFromDto(reservationRequest, reservationEntity);
        Reservation updatedReservation = reservationRepository.save(reservationEntity);
        return reservationMapper.toGetDTO(updatedReservation);
    }

    @Override
    public void delete(Long id) {
        Reservation reservationEntity = find(id);
        reservationRepository.delete(reservationEntity);
    }

    private Reservation find(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
    }
}
