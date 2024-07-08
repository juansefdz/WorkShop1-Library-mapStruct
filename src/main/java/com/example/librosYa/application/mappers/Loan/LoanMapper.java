package com.example.librosYa.application.mappers.Loan;


import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;

import com.example.librosYa.domain.entities.Loan;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {

    Loan toEntity(LoanRequest request);
    @InheritInverseConfiguration
    LoanResponse toResponse(Loan loan);
    List<LoanResponse> toGetLoanList(List<Loan> loanList);
    List<Loan> toEntityList(List<LoanRequest> loanRequestList);

    void updateEntityFromDto(LoanRequest dto, @MappingTarget Loan entity);
}
