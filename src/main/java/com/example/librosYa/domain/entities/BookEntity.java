package com.example.librosYa.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "book")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long idBook;

    @Column(name = "title_book", nullable = false, length = 100)
    private String titleBook;

    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @Column(name = "publication_year", nullable = false, length = 11)
    private int publicationYear;

    @Column(name = "genre", nullable = false, length = 50)
    private String genre;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @OneToMany(mappedBy = "book")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "book")
    private List<Loan> loans;


}
