package com.example.librosYa.application.controller;

import com.example.librosYa.application.dto.request.ReservationRequest;
import com.example.librosYa.application.dto.response.ReservationResponse;
import com.example.librosYa.infraestructure.abstract_services.IReservationService;
import com.example.librosYa.util.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reservations")
@AllArgsConstructor
@Tag(name = "Reservation Entity Controller")
public class ReservationController {

    private final IReservationService reservationService;

    /**
     * GET ALL Reservations
     */
    @Operation(
            summary = "Display all Reservations",
            description = "Displays all Reservations in a paginated list. Default page size is 10."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public Page<ReservationResponse> getAll(
            @Parameter(description = "Pageable object specifying the page requested", example = "1")
            Pageable pageable) {
        return reservationService.getAll(pageable);
    }

    /**
     * GET Reservation by ID
     */
    @Operation(
            summary = "Display Reservation by ID",
            description = "Displays a Reservation based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Reservation not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(path = "/{reservationId}")
    public ResponseEntity<ReservationResponse> getById(
            @Parameter(description = "Reservation ID", example = "1")
            @PathVariable Long reservationId) {

        ReservationResponse reservation = reservationService.getById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));

        return ResponseEntity.ok(reservation);
    }

    /**
     * CREATE Reservation
     */
    @Operation(
            summary = "Create a new Reservation",
            description = "Creates a new Reservation based on the provided data."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reservation created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<ReservationResponse> create(
            @Valid @RequestBody ReservationRequest request) {
        ReservationResponse createdReservation = reservationService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReservation);
    }

    /**
     * DELETE Reservation by ID
     */
    @Operation(
            summary = "Delete Reservation by ID",
            description = "Deletes a Reservation based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reservation deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Reservation not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(path = "/{reservationId}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Reservation ID", example = "1")
            @PathVariable Long reservationId) {
        reservationService.delete(reservationId);
        return ResponseEntity.noContent().build();
    }

    /**
     * UPDATE Reservation by ID
     */
    @Operation(
            summary = "Update Reservation by ID",
            description = "Updates an existing Reservation based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservation updated successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Reservation not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(path = "/{reservationId}")
    public ResponseEntity<ReservationResponse> update(
            @Valid @RequestBody ReservationRequest request,
            @Parameter(description = "Reservation ID", example = "1")
            @PathVariable Long reservationId) {
        ReservationResponse updatedReservation = reservationService.update(reservationId, request);
        return ResponseEntity.ok(updatedReservation);
    }

    /**
     * ADICIONAL ENDPOINTS
     */

    @GetMapping("/users/{user_id}/reservations")
    public ResponseEntity<List<ReservationResponse>> getAllReservationsByUserId(@PathVariable("user_id") Long userId) {
        List<ReservationResponse> reservations = reservationService.getAllByUserId(userId);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/books/{book_id}/reservations")
    public ResponseEntity<List<ReservationResponse>> getAllReservationsByBookId(@PathVariable("book_id") Long bookId) {
        List<ReservationResponse> reservations = reservationService.getAllByBookId(bookId);
        return ResponseEntity.ok(reservations);
    }
}
