package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoLoan;
import com.example.librosYa.domain.entities.Loan;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, BookMapper.class})
public interface LoanMapper {


    DtoLoan toGetDTO(Loan loan);

    @InheritInverseConfiguration
    Loan toEntity(DtoLoan loanRequest);
    List<DtoLoan> toGetLoanList(List<Loan> loanList);
    List<Loan> toEntityLoanList(List<DtoLoan> loanRequestList);
}

