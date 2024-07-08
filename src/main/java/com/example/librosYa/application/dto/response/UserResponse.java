package com.example.librosYa.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private long idUser;
    private String fullName;
    private String username;
    private String email;
    private String role;

}
