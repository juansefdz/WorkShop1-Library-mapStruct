package com.example.librosYa.api.controller;

import com.example.librosYa.api.dto.DtoUser;
import com.example.librosYa.infraestructure.abstract_services.IUserService;
import com.example.librosYa.util.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
@Tag(name = "User Entity Controller")
public class UserEntityController {

    @Autowired
    private final IUserService iUserService;

    /*----------------------------
     * GET ALL
     * ----------------------------
     */

    @Operation(
            summary = "Displays all Users",
            description = "Displays the Users in a list, it is configured to display 10 items per page."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping
    public ResponseEntity<Page<DtoUser>> getAll(
            @Parameter(description = "Page number (default: 1)", example = "1") // SWAGGER
            @RequestParam(defaultValue = "1") int page,
            @Parameter(description = "Number of items per page (default: 10)", example = "10") // SWAGGER
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iUserService.getAll(page - 1, size));
    }
    /*------------------------------
     * GET BY ID
     * -----------------------------
     */

    @Operation(
            summary = "Displays one user by id",
            description = "Shows the user by the ID sent or requested by path,value cannot be less than 1."
    ) //SWAGGER
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping(path = "/{user_id}")
    public ResponseEntity<DtoUser> getById(
            @Parameter(description = "User ID",example = "1") // SWAGGER
            @PathVariable Long user_id) {

        DtoUser user = this.iUserService.getById(user_id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }
        return ResponseEntity.ok(user);
    }

    /*--------------------
     * CREATE USER
     * -------------------
     */

    @Operation(
            summary = "creates a new user",
            description = "create a new user by entering the required data"
    ) //SWAGGER
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<DtoUser> create(@Validated @RequestBody DtoUser request) {
        return ResponseEntity.ok(this.iUserService.create(request));
    }

    /*----------------------
     * DELETE USER
     * ---------------------
     */

    @Operation(
            summary = "Delete user by ID",
            description = "deletes an user based on an ID to be sent by Path,value cannot be less than 1"
    ) //SWAGGER
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @DeleteMapping(path = "/{user_id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "User ID",example = "1") // SWAGGER
            @PathVariable Long user_id) {
        this.iUserService.delete(user_id);
        return ResponseEntity.noContent().build();
    }

    /*----------------------
     * UPDATE USER
     * ---------------------
     */

    @Operation(
            summary = "update  user by ID",
            description = "updates a previously created user and the ID and the new modified parameters must be sent through the Path, value cannot be less than 1"
    ) //SWAGGER
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PutMapping(path = "/{user_id}")
    public ResponseEntity<DtoUser> update(@Validated @RequestBody DtoUser request,
                                               @Parameter(description = "User ID",example = "1") // SWAGGER
                                               @PathVariable Long user_id) {
        return ResponseEntity.ok(this.iUserService.update(request, user_id));
    }
}