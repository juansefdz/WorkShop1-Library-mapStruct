package com.example.librosYa.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id",length = 20)
    private long idLoan;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "status", nullable = false, length = 20)
    private String status;



    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "fk_book_id", referencedColumnName = "book_id", nullable = false)
    private BookEntity book;


}
