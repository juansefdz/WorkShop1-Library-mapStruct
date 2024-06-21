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
    date = "2024-06-21T17:37:14-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public DtoUser toGetDTO(UserEntity user, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( user == null ) {
            return null;
        }

        DtoUser.DtoUserBuilder dtoUser = DtoUser.builder();

        if ( user.getIdUser() != null ) {
            dtoUser.idUser( user.getIdUser() );
        }
        dtoUser.username( user.getUsername() );
        dtoUser.password( user.getPassword() );
        dtoUser.email( user.getEmail() );
        dtoUser.fullName( user.getFullName() );
        dtoUser.role( user.getRole() );
        dtoUser.loans( loanListToDtoLoanList( user.getLoans(), reservationMapper, loanMapper ) );

        return dtoUser.build();
    }

    @Override
    public UserEntity toEntity(DtoUser getUser, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( getUser == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( getUser.getIdUser() );
        userEntity.username( getUser.getUsername() );
        userEntity.password( getUser.getPassword() );
        userEntity.email( getUser.getEmail() );
        userEntity.fullName( getUser.getFullName() );
        userEntity.role( getUser.getRole() );
        userEntity.loans( dtoLoanListToLoanList( getUser.getLoans(), reservationMapper, loanMapper ) );

        return userEntity.build();
    }

    @Override
    public List<DtoUser> toGetUserList(List<UserEntity> userList, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( userList == null ) {
            return null;
        }

        List<DtoUser> list = new ArrayList<DtoUser>( userList.size() );
        for ( UserEntity userEntity : userList ) {
            list.add( toGetDTO( userEntity, reservationMapper, loanMapper ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toEntityList(List<DtoUser> userRequestList, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( userRequestList == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( userRequestList.size() );
        for ( DtoUser dtoUser : userRequestList ) {
            list.add( toEntity( dtoUser, reservationMapper, loanMapper ) );
        }

        return list;
    }

    protected List<DtoLoan> loanListToDtoLoanList(List<Loan> list, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( list == null ) {
            return null;
        }

        List<DtoLoan> list1 = new ArrayList<DtoLoan>( list.size() );
        for ( Loan loan : list ) {
            list1.add( loanToDtoLoan( loan, reservationMapper, loanMapper ) );
        }

        return list1;
    }

    protected DtoBook bookEntityToDtoBook(BookEntity bookEntity, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( bookEntity == null ) {
            return null;
        }

        DtoBook.DtoBookBuilder dtoBook = DtoBook.builder();

        dtoBook.idBook( bookEntity.getIdBook() );
        dtoBook.titleBook( bookEntity.getTitleBook() );
        dtoBook.publicationYear( bookEntity.getPublicationYear() );
        dtoBook.genre( bookEntity.getGenre() );
        dtoBook.isbn( bookEntity.getIsbn() );
        dtoBook.loans( loanListToDtoLoanList( bookEntity.getLoans(), reservationMapper, loanMapper ) );

        return dtoBook.build();
    }

    protected DtoLoan loanToDtoLoan(Loan loan, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( loan == null ) {
            return null;
        }

        DtoLoan.DtoLoanBuilder dtoLoan = DtoLoan.builder();

        dtoLoan.idLoan( loan.getIdLoan() );
        dtoLoan.date( loan.getDate() );
        dtoLoan.returnDate( loan.getReturnDate() );
        dtoLoan.status( loan.getStatus() );
        dtoLoan.user( toGetDTO( loan.getUser(), reservationMapper, loanMapper ) );
        dtoLoan.book( bookEntityToDtoBook( loan.getBook(), reservationMapper, loanMapper ) );

        return dtoLoan.build();
    }

    protected List<Loan> dtoLoanListToLoanList(List<DtoLoan> list, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( list == null ) {
            return null;
        }

        List<Loan> list1 = new ArrayList<Loan>( list.size() );
        for ( DtoLoan dtoLoan : list ) {
            list1.add( dtoLoanToLoan( dtoLoan, reservationMapper, loanMapper ) );
        }

        return list1;
    }

    protected BookEntity dtoBookToBookEntity(DtoBook dtoBook, ReservationMapper reservationMapper, LoanMapper loanMapper) {
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
        bookEntity.loans( dtoLoanListToLoanList( dtoBook.getLoans(), reservationMapper, loanMapper ) );

        return bookEntity.build();
    }

    protected Loan dtoLoanToLoan(DtoLoan dtoLoan, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( dtoLoan == null ) {
            return null;
        }

        Loan.LoanBuilder loan = Loan.builder();

        loan.idLoan( dtoLoan.getIdLoan() );
        loan.date( dtoLoan.getDate() );
        loan.returnDate( dtoLoan.getReturnDate() );
        loan.status( dtoLoan.getStatus() );
        loan.user( toEntity( dtoLoan.getUser(), reservationMapper, loanMapper ) );
        loan.book( dtoBookToBookEntity( dtoLoan.getBook(), reservationMapper, loanMapper ) );

        return loan.build();
    }
}
