package com.example.librosYa.infraestructure.services;

import com.example.librosYa.api.dto.DtoLoan;
import com.example.librosYa.infraestructure.abstract_services.ILoanService;
import org.springframework.data.domain.Page;

public class LoanService implements ILoanService {
    @Override
    public Page<DtoLoan> getAll(int page, int size) {
        return null;
    }

    @Override
    public DtoLoan getById(Long id) {
        return null;
    }

    @Override
    public DtoLoan create(DtoLoan dtoRequest) {
        return null;
    }

    @Override
    public DtoLoan update(DtoLoan dtoRequest, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
