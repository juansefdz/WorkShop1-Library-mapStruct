package com.example.librosYa.application.dto.response;

import java.util.Date;

public class ReservationResponse {

    private long idReservation;
    private Date ReservationDate;
    private String status;

    private UserResponse user;
    private BookResponse book;
}
