package com.example.librosYa.application.mappers.Loan;


import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;

import com.example.librosYa.domain.entities.LoanEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanMapper {


    LoanEntity toEntity(LoanRequest request);
     
    @InheritInverseConfiguration 
    LoanResponse toResponse(LoanEntity loan);

    List<LoanResponse> toGetLoanList(List<LoanEntity> loanList);

    List<LoanEntity> toEntityList(List<LoanRequest> loanRequestList);

    @Mapping(target = "user", ignore = true)  
    void updateEntityFromDto(LoanRequest dto, @MappingTarget LoanEntity entity);
}

