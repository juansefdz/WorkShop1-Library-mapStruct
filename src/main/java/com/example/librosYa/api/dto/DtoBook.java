package com.example.librosYa.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoBook {

    private long idBook;
    @Schema(
            description = "Name of the Book",
            example = "100 Años de Soledad")                                               // SWAGGER
    @NotBlank(
            message = "The book name is required")                                   // validation
    @Size(
            max = 100,
            message = "The book name must have a maximum of 100 characters")
    private String titleBook;
    @Schema(
            description = "Author Name",
            example = "Gabriel Garcia Marquez")                                               // SWAGGER
    @NotBlank(
            message = "The ahtor of the book is required")                                   // validation
    @Size(
            max = 100,
            message = "The author book must have a maximum of 100 characters")
    private String Author;
    @Schema(
            description = "publication date",
            example = "1967")                                               // SWAGGER
    @NotBlank(
            message = "The year of publication  is required")                                   // validation
    @Size(
            max = 11,
            message = "the year of the publication can be superheated 11 characters")
    private int publicationYear;
    private String genre;
    private String isbn;

    private List<DtoLoan> loans;
    private List<DtoUser> users;
}
