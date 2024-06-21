package com.example.librosYa.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DtoReservation {
    private long idReservation;
    private Date ReservationDate;
    private String status;
}
