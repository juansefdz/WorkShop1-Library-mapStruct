package com.example.librosYa.application.controller;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.infraestructure.abstract_services.IBookService;
import com.example.librosYa.util.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/books")
@AllArgsConstructor
@Tag(name = "Book Entity Controller")
public class BookController {

    private final IBookService bookService;
    

    /**
     * GET ALL Books
     */
    @Operation(
            summary = "Display all Books",
            description = "Displays all Books in a paginated list. Default page size is 10."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public Page<BookResponse> getAll(
            @Parameter(description = "Pageable object specifying the page requested", example = "1")
            Pageable pageable) {
        return bookService.getAll(pageable);
    }

    /**
     * GET Book by ID
     */
    @Operation(
            summary = "Display Book by ID",
            description = "Displays a Book based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(path = "/{bookId}")
    public ResponseEntity<BookResponse> getById(
            @Parameter(description = "Book ID", example = "1")
            @PathVariable Long bookId) {

        BookResponse book = bookService.getById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

        return ResponseEntity.ok(book);
    }

    /**
     * CREATE Book
     */
    @Operation(
            summary = "Create a new Book",
            description = "Creates a new Book based on the provided data."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<BookResponse> create(
            @Valid @RequestBody BookRequest request) {
        BookResponse createdBook = bookService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    /**
     * DELETE Book by ID
     */
    @Operation(
            summary = "Delete Book by ID",
            description = "Deletes a Book based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(path = "/{bookId}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Book ID", example = "1")
            @PathVariable Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.noContent().build();
    }

    /**
     * UPDATE Book by ID
     */
    @Operation(
            summary = "Update Book by ID",
            description = "Updates an existing Book based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book updated successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Book not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(path = "/{bookId}")
    public ResponseEntity<BookResponse> update(
            @Valid @RequestBody BookRequest request,
            @Parameter(description = "Book ID", example = "1")
            @PathVariable Long bookId) {
        BookResponse updatedBook = bookService.update(bookId, request);
        return ResponseEntity.ok(updatedBook);
    }
}
