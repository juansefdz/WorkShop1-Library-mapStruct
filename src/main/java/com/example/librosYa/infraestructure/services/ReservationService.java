package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.application.mappers.Reservation.ReservationMapper;
import com.example.librosYa.domain.entities.ReservationEntity;
import com.example.librosYa.domain.repositories.ReservationRepository;
import com.example.librosYa.infraestructure.abstract_services.IReservationService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private final ReservationMapper reservationMapper;

    @Override
    public Page<ReservationResponse> getAll(Pageable pageable) {
        return reservationRepository.findAll(pageable).map(reservationMapper::toResponse);
    }

    @Override
    public Optional<ReservationResponse> getById(Long id) {
        Optional<ReservationEntity> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(reservationMapper::toResponse);
    }

    @Override
    @Transactional
    public ReservationResponse create(ReservationRequest reservationRequest) {
        ReservationEntity reservation = reservationMapper.toEntity(reservationRequest);
        ReservationEntity savedReservation = reservationRepository.save(reservation);
        return reservationMapper.toResponse(savedReservation);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ReservationEntity reservationEntity = find(id);
        reservationRepository.delete(reservationEntity);
    }

    private ReservationEntity find(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + id));
    }

    @Override
    @Transactional
    public ReservationResponse update(Long id, ReservationRequest reservationRequest) {
        ReservationEntity reservationEntity = find(id);
        reservationMapper.updateEntityFromDto(reservationRequest, reservationEntity);
        ReservationEntity updatedReservationEntity = reservationRepository.save(reservationEntity);
        return reservationMapper.toResponse(updatedReservationEntity);
    }

    @Override
    @Transactional
    public List<ReservationResponse> getAllByUserId(Long userId) {
        List<ReservationEntity> reservations = reservationRepository.findAllByUser_IdUser(userId);
        return reservationMapper.toResponseList(reservations);
    }

    @Override
    @Transactional
    public List<ReservationResponse> getAllByBookId(Long bookId) {
        List<ReservationEntity> reservations = reservationRepository.findAllByBook_IdBook(bookId);
        return reservationMapper.toResponseList(reservations);
    }

}
