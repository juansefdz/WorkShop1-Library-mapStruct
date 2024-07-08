package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.application.mappers.Loan.LoanMapper;
import com.example.librosYa.domain.entities.Loan;
import com.example.librosYa.domain.repositories.LoanRepository;
import com.example.librosYa.infraestructure.abstract_services.ILoanService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService implements ILoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    @Override
    public LoanResponse create(LoanRequest loanRequest) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<LoanResponse> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<LoanResponse> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public LoanResponse update(Long aLong, LoanRequest loanRequest) {
        return null;
    }
}
