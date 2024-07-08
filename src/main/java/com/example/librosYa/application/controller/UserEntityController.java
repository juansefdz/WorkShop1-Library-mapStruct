package com.example.librosYa.application.controller;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.application.mappers.User.UserMapper;
import com.example.librosYa.infraestructure.abstract_services.IUserService;
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
@RequestMapping(path = "/users")
@AllArgsConstructor
@Tag(name = "User Entity Controller")
public class UserEntityController {

    private final IUserService iUserService;
    private final UserMapper userMapper;

    /**
     * GET ALL Users
     */
    @Operation(
            summary = "Display all Users",
            description = "Displays all Users in a paginated list. Default page size is 10."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public Page<UserResponse> getAll(
            @Parameter(description = "Pageable object specifying the page requested", example = "1") // Swagger
            Pageable pageable) {
        return iUserService.getAll(pageable);
    }

    /**
     * GET User by ID
     */
    @Operation(
            summary = "Display User by ID",
            description = "Displays a User based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserResponse> getById(
            @Parameter(description = "User ID", example = "1")
            @PathVariable Long userId) {

        UserResponse user = iUserService.getById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        return ResponseEntity.ok(user);
    }

    /**
     * CREATE User
     */
    @Operation(
            summary = "Create a new User",
            description = "Creates a new User based on the provided data."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<UserResponse> create(
            @Valid @RequestBody UserRequest request) {
        UserResponse createdUser = iUserService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * DELETE User by ID
     */
    @Operation(
            summary = "Delete User by ID",
            description = "Deletes a User based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "User ID", example = "1")
            @PathVariable Long userId) {
        iUserService.delete(userId);
        return ResponseEntity.noContent().build();
    }

    /**
     * UPDATE User by ID
     */
    @Operation(
            summary = "Update User by ID",
            description = "Updates an existing User based on the provided ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(path = "/{userId}")
    public ResponseEntity<UserResponse> update(
            @Valid @RequestBody UserRequest request,
            @Parameter(description = "User ID", example = "1")
            @PathVariable Long userId) {
        UserResponse updatedUser = iUserService.update(userId, request);
        return ResponseEntity.ok(updatedUser);
    }
}
