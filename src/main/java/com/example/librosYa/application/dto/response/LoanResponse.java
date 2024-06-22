package com.example.librosYa.application.dto.response;

import java.util.Date;

public class LoanResponse {

    private long idLoan;
    private Date date;
    private Date returnDate;
    private String status;

    private UserResponse user;
    private BookResponse book;
}
