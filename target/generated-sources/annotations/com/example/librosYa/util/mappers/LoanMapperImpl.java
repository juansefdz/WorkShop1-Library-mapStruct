package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoBook;
import com.example.librosYa.api.dto.DtoLoan;
import com.example.librosYa.api.dto.DtoUser;
import com.example.librosYa.domain.entities.BookEntity;
import com.example.librosYa.domain.entities.Loan;
import com.example.librosYa.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T19:10:57-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public DtoLoan toGetDTO(Loan loan, UserMapper userMapper) {
        if ( loan == null ) {
            return null;
        }

        DtoLoan.DtoLoanBuilder dtoLoan = DtoLoan.builder();

        dtoLoan.idLoan( loan.getIdLoan() );
        dtoLoan.date( loan.getDate() );
        dtoLoan.returnDate( loan.getReturnDate() );
        dtoLoan.status( loan.getStatus() );
        dtoLoan.user( userEntityToDtoUser( loan.getUser(), userMapper ) );
        dtoLoan.book( bookEntityToDtoBook( loan.getBook(), userMapper ) );

        return dtoLoan.build();
    }

    @Override
    public Loan toEntity(DtoLoan loanRequest, UserMapper userMapper) {
        if ( loanRequest == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.idLoan( loanRequest.getIdLoan() );
        loan.date( loanRequest.getDate() );
        loan.returnDate( loanRequest.getReturnDate() );
        loan.status( loanRequest.getStatus() );
        loan.user( dtoUserToUserEntity( loanRequest.getUser(), userMapper ) );
        loan.book( dtoBookToBookEntity( loanRequest.getBook(), userMapper ) );

        return loan.build();
    }

    @Override
    public List<DtoLoan> toGetLoanList(List<Loan> loanList) {
        if ( loanList == null ) {
            return null;
        }

        List<DtoLoan> list = new ArrayList<DtoLoan>( loanList.size() );
        for ( Loan loan : loanList ) {
            list.add( loanToDtoLoan( loan ) );
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
            list.add( dtoLoanToLoan( dtoLoan ) );
        }

        return list;
    }

    protected DtoUser userEntityToDtoUser(UserEntity userEntity, UserMapper userMapper) {
        if ( userEntity == null ) {
            return null;
        }

        DtoUser.DtoUserBuilder dtoUser = DtoUser.builder();

        if ( userEntity.getIdUser() != null ) {
            dtoUser.idUser( userEntity.getIdUser() );
        }
        dtoUser.username( userEntity.getUsername() );
        dtoUser.password( userEntity.getPassword() );
        dtoUser.email( userEntity.getEmail() );
        dtoUser.fullName( userEntity.getFullName() );
        dtoUser.role( userEntity.getRole() );
        dtoUser.loans( toGetLoanList( userEntity.getLoans() ) );

        return dtoUser.build();
    }

    protected DtoBook bookEntityToDtoBook(BookEntity bookEntity, UserMapper userMapper) {
        if ( bookEntity == null ) {
            return null;
        }

        DtoBook.DtoBookBuilder dtoBook = DtoBook.builder();

        dtoBook.idBook( bookEntity.getIdBook() );
        dtoBook.titleBook( bookEntity.getTitleBook() );
        dtoBook.publicationYear( bookEntity.getPublicationYear() );
        dtoBook.genre( bookEntity.getGenre() );
        dtoBook.isbn( bookEntity.getIsbn() );
        dtoBook.loans( toGetLoanList( bookEntity.getLoans() ) );

        return dtoBook.build();
    }

    protected UserEntity dtoUserToUserEntity(DtoUser dtoUser, UserMapper userMapper) {
        if ( dtoUser == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( dtoUser.getIdUser() );
        userEntity.username( dtoUser.getUsername() );
        userEntity.password( dtoUser.getPassword() );
        userEntity.email( dtoUser.getEmail() );
        userEntity.fullName( dtoUser.getFullName() );
        userEntity.role( dtoUser.getRole() );
        userEntity.loans( toEntityLoanList( dtoUser.getLoans() ) );

        return userEntity.build();
    }

    protected BookEntity dtoBookToBookEntity(DtoBook dtoBook, UserMapper userMapper) {
        if ( dtoBook == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.idBook( dtoBook.getIdBook() );
        bookEntity.titleBook( dtoBook.getTitleBook() );
        bookEntity.author( dtoBook.getAuthor() );
        bookEntity.publicationYear( dtoBook.getPublicationYear() );
        bookEntity.genre( dtoBook.getGenre() );
        bookEntity.isbn( dtoBook.getIsbn() );
        bookEntity.loans( toEntityLoanList( dtoBook.getLoans() ) );

        return bookEntity.build();
    }

    protected DtoUser userEntityToDtoUser1(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        DtoUser.DtoUserBuilder dtoUser = DtoUser.builder();

        if ( userEntity.getIdUser() != null ) {
            dtoUser.idUser( userEntity.getIdUser() );
        }
        dtoUser.username( userEntity.getUsername() );
        dtoUser.password( userEntity.getPassword() );
        dtoUser.email( userEntity.getEmail() );
        dtoUser.fullName( userEntity.getFullName() );
        dtoUser.role( userEntity.getRole() );
        dtoUser.loans( toGetLoanList( userEntity.getLoans() ) );

        return dtoUser.build();
    }

    protected DtoBook bookEntityToDtoBook1(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        DtoBook.DtoBookBuilder dtoBook = DtoBook.builder();

        dtoBook.idBook( bookEntity.getIdBook() );
        dtoBook.titleBook( bookEntity.getTitleBook() );
        dtoBook.publicationYear( bookEntity.getPublicationYear() );
        dtoBook.genre( bookEntity.getGenre() );
        dtoBook.isbn( bookEntity.getIsbn() );
        dtoBook.loans( toGetLoanList( bookEntity.getLoans() ) );

        return dtoBook.build();
    }

    protected DtoLoan loanToDtoLoan(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        DtoLoan.DtoLoanBuilder dtoLoan = DtoLoan.builder();

        dtoLoan.idLoan( loan.getIdLoan() );
        dtoLoan.date( loan.getDate() );
        dtoLoan.returnDate( loan.getReturnDate() );
        dtoLoan.status( loan.getStatus() );
        dtoLoan.user( userEntityToDtoUser1( loan.getUser() ) );
        dtoLoan.book( bookEntityToDtoBook1( loan.getBook() ) );

        return dtoLoan.build();
    }

    protected UserEntity dtoUserToUserEntity1(DtoUser dtoUser) {
        if ( dtoUser == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( dtoUser.getIdUser() );
        userEntity.username( dtoUser.getUsername() );
        userEntity.password( dtoUser.getPassword() );
        userEntity.email( dtoUser.getEmail() );
        userEntity.fullName( dtoUser.getFullName() );
        userEntity.role( dtoUser.getRole() );
        userEntity.loans( toEntityLoanList( dtoUser.getLoans() ) );

        return userEntity.build();
    }

    protected BookEntity dtoBookToBookEntity1(DtoBook dtoBook) {
        if ( dtoBook == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.idBook( dtoBook.getIdBook() );
        bookEntity.titleBook( dtoBook.getTitleBook() );
        bookEntity.author( dtoBook.getAuthor() );
        bookEntity.publicationYear( dtoBook.getPublicationYear() );
        bookEntity.genre( dtoBook.getGenre() );
        bookEntity.isbn( dtoBook.getIsbn() );
        bookEntity.loans( toEntityLoanList( dtoBook.getLoans() ) );

        return bookEntity.build();
    }

    protected Loan dtoLoanToLoan(DtoLoan dtoLoan) {
        if ( dtoLoan == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.idLoan( dtoLoan.getIdLoan() );
        loan.date( dtoLoan.getDate() );
        loan.returnDate( dtoLoan.getReturnDate() );
        loan.status( dtoLoan.getStatus() );
        loan.user( dtoUserToUserEntity1( dtoLoan.getUser() ) );
        loan.book( dtoBookToBookEntity1( dtoLoan.getBook() ) );

        return loan.build();
    }
}
