package com.example.librosYa.domain.repositories;

import com.example.librosYa.domain.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
