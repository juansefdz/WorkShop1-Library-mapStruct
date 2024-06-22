package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.domain.entities.Loan;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, BookMapper.class})
public interface LoanMapper {
    LoanResponse toGetDTO(Loan loan);

    @InheritInverseConfiguration
    Loan toEntity(LoanRequest request);

    List<LoanResponse> toGetLoanList(List<Loan> loanList);
    List<Loan> toEntityList(List<LoanRequest> loanRequestList);

    void updateEntityFromDto(LoanRequest dto, @MappingTarget Loan entity);
}
