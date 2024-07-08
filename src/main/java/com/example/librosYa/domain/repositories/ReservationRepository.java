package com.example.librosYa.domain.repositories;

import com.example.librosYa.domain.entities.ReservationEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {

    List<ReservationEntity> findAllByUser_IdUser(Long userId);

    List<ReservationEntity> findAllByBook_IdBook(Long bookId);
}
