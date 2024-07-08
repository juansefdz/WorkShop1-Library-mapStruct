package com.example.librosYa.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private long idBook;
    private String titleBook;
    private String Author;
    private int publicationYear;
    private String genre;
    private String isbn;
}
