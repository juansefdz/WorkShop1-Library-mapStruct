package com.example.librosYa.application.controller;

import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.application.mappers.Loan.LoanMapper;
import com.example.librosYa.infraestructure.abstract_services.ILoanService;
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
@RequestMapping(path = "/loans")
@AllArgsConstructor
@Tag(name = "Loan Entity Controller")
public class LoanController {

    private final ILoanService loanService;
    private final LoanMapper loanMapper;

    /**
     * GET ALL Loans
     */
    @Operation(
            summary = "Display all Loans",
            description = "Displays all Loans in a paginated list. Default page size is 10."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public Page<LoanResponse> getAll(
            @Parameter(description = "Pageable object specifying the page requested", example = "1")
            Pageable pageable) {
        return loanService.getAll(pageable);
    }

    /**
     * GET Loan by ID
     */
    @Operation(
            summary = "Display Loan by ID",
            description = "Displays a Loan based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Loan not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(path = "/{loanId}")
    public ResponseEntity<LoanResponse> getById(
            @Parameter(description = "Loan ID", example = "1")
            @PathVariable Long loanId) {

        LoanResponse loan = loanService.getById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + loanId));

        return ResponseEntity.ok(loan);
    }

    /**
     * CREATE Loan
     */
    @Operation(
            summary = "Create a new Loan",
            description = "Creates a new Loan based on the provided data."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Loan created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<LoanResponse> create(
            @Valid @RequestBody LoanRequest request) {
        LoanResponse createdLoan = loanService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
    }

    /**
     * DELETE Loan by ID
     */
    @Operation(
            summary = "Delete Loan by ID",
            description = "Deletes a Loan based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Loan deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Loan not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(path = "/{loanId}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Loan ID", example = "1")
            @PathVariable Long loanId) {
        loanService.delete(loanId);
        return ResponseEntity.noContent().build();
    }

    /**
     * UPDATE Loan by ID
     */
    @Operation(
            summary = "Update Loan by ID",
            description = "Updates an existing Loan based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Loan updated successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Loan not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(path = "/{loanId}")
    public ResponseEntity<LoanResponse> update(
            @Valid @RequestBody LoanRequest request,
            @Parameter(description = "Loan ID", example = "1")
            @PathVariable Long loanId) {
        LoanResponse updatedLoan = loanService.update(loanId, request);
        return ResponseEntity.ok(updatedLoan);
    }
}
