package com.example.librosYa.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private long idUser;
    @Schema(
            description = "Name of the user",
            example = "john_doe")
    @NotBlank(
            message = "The username is required")                                   // validation
    @Size(
            max = 50,
            message = "The username must have a maximum of 50 characters")
    private String username;
    @Schema(
            description = "Password of the user")                               // SWAGGER
    @NotBlank(
            message = "The password is required")
    private String password;
    @Schema(
            description = "Email of the user",
            example = "john@example.com")                                       // SWAGGER
    @NotBlank(
            message = "The email is required")                                  // validation
    @Email(message = "the email must be valid")
    private String email;
    @Schema(
            description = "Name of the user",
            example = "john_doe")                                               // SWAGGER
    @NotBlank(
            message = "The name is required")                                   // validation
    @Size(
            max = 100,
            message = "The name must have a maximum of 100 characters")
    private String fullName;
    @Schema(
            description = "Rol of the user",
            example = "STUDENT")                                               // SWAGGER
    @NotBlank(
            message = "The role is required")                                   // validation
    @Size(
            max = 20,
            message = "the maximum size of the role is 20 characters ")
    private String role;


}
