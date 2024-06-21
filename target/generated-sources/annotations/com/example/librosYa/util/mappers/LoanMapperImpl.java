package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoLoan;
import com.example.librosYa.domain.entities.Loan;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T12:16:01-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public DtoLoan toGetDTO(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        DtoLoan.DtoLoanBuilder dtoLoan = DtoLoan.builder();

        dtoLoan.idLoan( loan.getIdLoan() );
        dtoLoan.date( loan.getDate() );
        dtoLoan.returnDate( loan.getReturnDate() );
        dtoLoan.status( loan.getStatus() );
        dtoLoan.user( userMapper.toGetDTO( loan.getUser() ) );
        dtoLoan.book( bookMapper.toGetDTO( loan.getBook() ) );

        return dtoLoan.build();
    }

    @Override
    public Loan toEntity(DtoLoan loanRequest) {
        if ( loanRequest == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.idLoan( loanRequest.getIdLoan() );
        loan.date( loanRequest.getDate() );
        loan.returnDate( loanRequest.getReturnDate() );
        loan.status( loanRequest.getStatus() );
        loan.user( userMapper.toEntity( loanRequest.getUser() ) );
        loan.book( bookMapper.toEntity( loanRequest.getBook() ) );

        return loan.build();
    }

    @Override
    public List<DtoLoan> toGetLoanList(List<Loan> loanList) {
        if ( loanList == null ) {
            return null;
        }

        List<DtoLoan> list = new ArrayList<DtoLoan>( loanList.size() );
        for ( Loan loan : loanList ) {
            list.add( toGetDTO( loan ) );
        }

        return list;
    }

    @Override
    public List<Loan> toEntityLoanList(List<DtoLoan> loanRequestList) {
        if ( loanRequestList == null ) {
            return null;
        }

        List<Loan> list = new ArrayList<Loan>( loanRequestList.size() );
        for ( DtoLoan dtoLoan : loanRequestList ) {
            list.add( toEntity( dtoLoan ) );
        }

        return list;
    }
}
