package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.domain.entities.BookEntity;
import com.example.librosYa.domain.entities.Loan;
import com.example.librosYa.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-22T12:13:33-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookResponse toGetDTO(BookEntity book) {
        if ( book == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        return bookResponse;
    }

    @Override
    public BookEntity toEntity(BookRequest request) {
        if ( request == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.idBook( request.getIdBook() );
        bookEntity.titleBook( request.getTitleBook() );
        bookEntity.author( request.getAuthor() );
        bookEntity.publicationYear( request.getPublicationYear() );
        bookEntity.genre( request.getGenre() );
        bookEntity.isbn( request.getIsbn() );
        bookEntity.loans( loanRequestListToLoanList( request.getLoans() ) );

        return bookEntity.build();
    }

    @Override
    public List<BookResponse> toGetBookList(List<BookEntity> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookResponse> list = new ArrayList<BookResponse>( bookList.size() );
        for ( BookEntity bookEntity : bookList ) {
            list.add( toGetDTO( bookEntity ) );
        }

        return list;
    }

    @Override
    public List<BookEntity> toEntityList(List<BookRequest> bookRequestList) {
        if ( bookRequestList == null ) {
            return null;
        }

        List<BookEntity> list = new ArrayList<BookEntity>( bookRequestList.size() );
        for ( BookRequest bookRequest : bookRequestList ) {
            list.add( toEntity( bookRequest ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(BookRequest dto, BookEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setIdBook( dto.getIdBook() );
        entity.setTitleBook( dto.getTitleBook() );
        entity.setAuthor( dto.getAuthor() );
        entity.setPublicationYear( dto.getPublicationYear() );
        entity.setGenre( dto.getGenre() );
        entity.setIsbn( dto.getIsbn() );
        if ( entity.getLoans() != null ) {
            List<Loan> list = loanRequestListToLoanList( dto.getLoans() );
            if ( list != null ) {
                entity.getLoans().clear();
                entity.getLoans().addAll( list );
            }
            else {
                entity.setLoans( null );
            }
        }
        else {
            List<Loan> list = loanRequestListToLoanList( dto.getLoans() );
            if ( list != null ) {
                entity.setLoans( list );
            }
        }
    }

    protected UserEntity userRequestToUserEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( userRequest.getIdUser() );
        userEntity.username( userRequest.getUsername() );
        userEntity.password( userRequest.getPassword() );
        userEntity.email( userRequest.getEmail() );
        userEntity.fullName( userRequest.getFullName() );
        userEntity.role( userRequest.getRole() );

        return userEntity.build();
    }

    protected Loan loanRequestToLoan(LoanRequest loanRequest) {
        if ( loanRequest == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.idLoan( loanRequest.getIdLoan() );
        loan.date( loanRequest.getDate() );
        loan.returnDate( loanRequest.getReturnDate() );
        loan.status( loanRequest.getStatus() );
        loan.user( userRequestToUserEntity( loanRequest.getUser() ) );
        loan.book( toEntity( loanRequest.getBook() ) );

        return loan.build();
    }

    protected List<Loan> loanRequestListToLoanList(List<LoanRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<Loan> list1 = new ArrayList<Loan>( list.size() );
        for ( LoanRequest loanRequest : list ) {
            list1.add( loanRequestToLoan( loanRequest ) );
        }

        return list1;
    }
}
