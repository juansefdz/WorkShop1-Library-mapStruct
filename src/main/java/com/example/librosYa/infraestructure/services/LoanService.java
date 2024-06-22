package com.example.librosYa.infraestructure.services;

import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.application.mappers.LoanMapper;
import com.example.librosYa.domain.entities.Loan;
import com.example.librosYa.domain.repositories.LoanRepository;
import com.example.librosYa.infraestructure.abstract_services.CRUDService;
import com.example.librosYa.infraestructure.abstract_services.ILoanService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanService implements ILoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    public LoanService(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    @Override
    public Page<LoanResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return loanRepository.findAll(pagination).map(loanMapper::toGetDTO);
    }

    @Override
    public LoanResponse getById(Long id) {
        Loan loanEntity = find(id);
        return loanMapper.toGetDTO(loanEntity);
    }

    @Override
    public LoanResponse create(LoanRequest loanRequest) {
        Loan loanEntity = loanMapper.toEntity(loanRequest);
        Loan savedLoan = loanRepository.save(loanEntity);
        return loanMapper.toGetDTO(savedLoan);
    }

    @Override
    public LoanResponse update(LoanRequest loanRequest, Long id) {
        Loan loanEntity = find(id);
        loanMapper.updateEntityFromDto(loanRequest, loanEntity);
        Loan updatedLoan = loanRepository.save(loanEntity);
        return loanMapper.toGetDTO(updatedLoan);
    }

    @Override
    public void delete(Long id) {
        Loan loanEntity = find(id);
        loanRepository.delete(loanEntity);
    }

    private Loan find(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Loan not found with id: " + id));
    }
}
