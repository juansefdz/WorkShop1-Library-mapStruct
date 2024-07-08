package com.example.librosYa.application.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {

    private long idReservation;
    private Date ReservationDate;
    private String status;

    private UserResponse user;
    private BookResponse book;
}
