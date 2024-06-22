package com.example.librosYa.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanRequest {
    private long idLoan;
    private Date date;
    private Date returnDate;
    private String status;

    private UserRequest user;
    private BookRequest book;
}
