package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.domain.entities.BookEntity;
import com.example.librosYa.domain.entities.Loan;
import com.example.librosYa.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-22T12:13:33-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public LoanResponse toGetDTO(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponse loanResponse = new LoanResponse();

        return loanResponse;
    }

    @Override
    public Loan toEntity(LoanRequest request) {
        if ( request == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.idLoan( request.getIdLoan() );
        loan.date( request.getDate() );
        loan.returnDate( request.getReturnDate() );
        loan.status( request.getStatus() );
        loan.user( userMapper.toEntity( request.getUser() ) );
        loan.book( bookMapper.toEntity( request.getBook() ) );

        return loan.build();
    }

    @Override
    public List<LoanResponse> toGetLoanList(List<Loan> loanList) {
        if ( loanList == null ) {
            return null;
        }

        List<LoanResponse> list = new ArrayList<LoanResponse>( loanList.size() );
        for ( Loan loan : loanList ) {
            list.add( toGetDTO( loan ) );
        }

        return list;
    }

    @Override
    public List<Loan> toEntityList(List<LoanRequest> loanRequestList) {
        if ( loanRequestList == null ) {
            return null;
        }

        List<Loan> list = new ArrayList<Loan>( loanRequestList.size() );
        for ( LoanRequest loanRequest : loanRequestList ) {
            list.add( toEntity( loanRequest ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(LoanRequest dto, Loan entity) {
        if ( dto == null ) {
            return;
        }

        entity.setIdLoan( dto.getIdLoan() );
        entity.setDate( dto.getDate() );
        entity.setReturnDate( dto.getReturnDate() );
        entity.setStatus( dto.getStatus() );
        if ( dto.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( UserEntity.builder().build() );
            }
            userMapper.updateEntityFromDto( dto.getUser(), entity.getUser() );
        }
        else {
            entity.setUser( null );
        }
        if ( dto.getBook() != null ) {
            if ( entity.getBook() == null ) {
                entity.setBook( BookEntity.builder().build() );
            }
            bookMapper.updateEntityFromDto( dto.getBook(), entity.getBook() );
        }
        else {
            entity.setBook( null );
        }
    }
}
