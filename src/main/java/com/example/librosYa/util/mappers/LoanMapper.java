package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoLoan;
import com.example.librosYa.domain.entities.Loan;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class, BookMapper.class})
public interface LoanMapper {

    DtoLoan toGetDTO(Loan loan, @Context UserMapper userMapper, @Context BookMapper bookMapper);

    @InheritInverseConfiguration
    Loan toEntity(DtoLoan loanRequest, @Context UserMapper userMapper, @Context BookMapper bookMapper);

    List<DtoLoan> toGetLoanList(List<Loan> loanList, @Context UserMapper userMapper, @Context BookMapper bookMapper);

    List<Loan> toEntityLoanList(List<DtoLoan> loanRequestList, @Context UserMapper userMapper, @Context BookMapper bookMapper);
}


