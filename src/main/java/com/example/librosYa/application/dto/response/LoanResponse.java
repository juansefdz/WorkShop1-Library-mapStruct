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
public class LoanResponse {

    private long idLoan;
    private Date date;
    private Date returnDate;
    private String status;

    private UserResponse user;
    private BookResponse book;
}
