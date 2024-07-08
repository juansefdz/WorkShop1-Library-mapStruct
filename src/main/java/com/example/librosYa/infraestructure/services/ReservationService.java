package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.application.mappers.Reservation.ReservationMapper;
import com.example.librosYa.domain.entities.Reservation;
import com.example.librosYa.domain.entities.UserEntity;
import com.example.librosYa.domain.repositories.ReservationRepository;
import com.example.librosYa.infraestructure.abstract_services.IReservationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }
    @Override
    public Page<ReservationResponse> getAll(Pageable pageable) {
        return reservationRepository.findAll(pageable).map(reservationMapper::toResponse);
    }


    @Override
    public Optional<ReservationResponse> getById(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(reservationMapper::toResponse);
    }

    @Override
    @Transactional
    public ReservationResponse create(ReservationRequest reservationRequest) {
        Reservation reservation = reservationMapper.toEntity(reservationRequest);
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.toResponse(savedReservation);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Reservation reservationEntity = find(id);
        reservationRepository.delete(reservationEntity);
    }

    private Reservation find(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
    }

    @Override
    @Transactional
    public ReservationResponse update(Long id, ReservationRequest reservationRequest) {
        Reservation reservationEntity = find(id);
        reservationMapper.updateEntityFromDto(reservationRequest, reservationEntity);
        Reservation updatedReservationEntity = reservationRepository.save(reservationEntity);
        return reservationMapper.toResponse(updatedReservationEntity);
    }


}
