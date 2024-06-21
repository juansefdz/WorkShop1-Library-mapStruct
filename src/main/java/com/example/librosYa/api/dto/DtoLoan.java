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
public class DtoLoan {
    private long idLoan;
    private Date date;
    private Date returnDate;
    private String status;

    private DtoUser user;
    private DtoBook book;
}
