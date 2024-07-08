package com.example.librosYa.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long idUser;
    @Column(name = "user_name", nullable = false, length = 50)
    private String username;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;
    @Column(name = "role", nullable = false, length = 20)
    private String role;

    @OneToMany(mappedBy = "user")
    private List<ReservationEntity> reservations;

    @OneToMany(mappedBy = "user")
    private List<LoanEntity> loans;
}
