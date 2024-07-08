package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.application.mappers.Loan.LoanMapper;
import com.example.librosYa.domain.entities.LoanEntity;
import com.example.librosYa.domain.repositories.LoanRepository;
import com.example.librosYa.infraestructure.abstract_services.ILoanService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanService implements ILoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Override
    @Transactional
    public LoanResponse create(LoanRequest loanRequest) {
        LoanEntity loanEntity = loanMapper.toEntity(loanRequest);
        LoanEntity savedLoan = loanRepository.save(loanEntity);
        return loanMapper.toResponse(savedLoan);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        LoanEntity loanEntity = find(id);
        loanRepository.delete(loanEntity);
    }

    @Override
    public Page<LoanResponse> getAll(Pageable pageable) {
        return loanRepository.findAll(pageable).map(loanMapper::toResponse);
    }

    @Override
    public Optional<LoanResponse> getById(Long id) {
        Optional<LoanEntity> loanOptional = loanRepository.findById(id);
        return loanOptional.map(loanMapper::toResponse);
    }

    private LoanEntity find(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Loan not found with id: " + id));
    }

    @Override
    @Transactional
    public LoanResponse update(Long id, LoanRequest loanRequest) {
        LoanEntity loanEntity = find(id);
        loanMapper.updateEntityFromDto(loanRequest, loanEntity);
        LoanEntity updatedLoan = loanRepository.save(loanEntity);
        return loanMapper.toResponse(updatedLoan);
    }
}
