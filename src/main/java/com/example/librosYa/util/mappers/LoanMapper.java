package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoLoan;
import com.example.librosYa.domain.entities.Loan;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {

    DtoLoan toGetDTO(Loan loan, @Context UserMapper userMapper);

    @InheritInverseConfiguration
    Loan toEntity(DtoLoan loanRequest, @Context UserMapper userMapper);

    List<DtoLoan> toGetLoanList(List<Loan> loanList);

    List<Loan> toEntityLoanList(List<DtoLoan> loanRequestList);
}


