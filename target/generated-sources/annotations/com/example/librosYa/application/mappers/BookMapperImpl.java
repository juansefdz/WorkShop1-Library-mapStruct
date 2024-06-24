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
    date = "2024-06-23T19:46:58-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
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

        bookEntity.author( request.getAuthor() );
        bookEntity.genre( request.getGenre() );
        bookEntity.idBook( request.getIdBook() );
        bookEntity.isbn( request.getIsbn() );
        bookEntity.loans( loanRequestListToLoanList( request.getLoans() ) );
        bookEntity.publicationYear( request.getPublicationYear() );
        bookEntity.titleBook( request.getTitleBook() );

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

        entity.setAuthor( dto.getAuthor() );
        entity.setGenre( dto.getGenre() );
        entity.setIdBook( dto.getIdBook() );
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
        entity.setPublicationYear( dto.getPublicationYear() );
        entity.setTitleBook( dto.getTitleBook() );
    }

    protected UserEntity userRequestToUserEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( userRequest.getEmail() );
        userEntity.fullName( userRequest.getFullName() );
        userEntity.idUser( userRequest.getIdUser() );
        userEntity.password( userRequest.getPassword() );
        userEntity.role( userRequest.getRole() );
        userEntity.username( userRequest.getUsername() );

        return userEntity.build();
    }

    protected Loan loanRequestToLoan(LoanRequest loanRequest) {
        if ( loanRequest == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.book( toEntity( loanRequest.getBook() ) );
        loan.date( loanRequest.getDate() );
        loan.idLoan( loanRequest.getIdLoan() );
        loan.returnDate( loanRequest.getReturnDate() );
        loan.status( loanRequest.getStatus() );
        loan.user( userRequestToUserEntity( loanRequest.getUser() ) );

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
