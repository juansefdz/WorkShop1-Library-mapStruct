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
public class BookMapperImpl implements BookMapper {

    @Override
    public DtoBook toGetDTO(BookEntity book, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( book == null ) {
            return null;
        }

        DtoBook.DtoBookBuilder dtoBook = DtoBook.builder();

        dtoBook.idBook( book.getIdBook() );
        dtoBook.titleBook( book.getTitleBook() );
        dtoBook.publicationYear( book.getPublicationYear() );
        dtoBook.genre( book.getGenre() );
        dtoBook.isbn( book.getIsbn() );
        dtoBook.loans( loanListToDtoLoanList( book.getLoans(), reservationMapper, loanMapper ) );

        return dtoBook.build();
    }

    @Override
    public BookEntity toEntity(DtoBook getBook, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( getBook == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.idBook( getBook.getIdBook() );
        bookEntity.titleBook( getBook.getTitleBook() );
        bookEntity.author( getBook.getAuthor() );
        bookEntity.publicationYear( getBook.getPublicationYear() );
        bookEntity.genre( getBook.getGenre() );
        bookEntity.isbn( getBook.getIsbn() );
        bookEntity.loans( dtoLoanListToLoanList( getBook.getLoans(), reservationMapper, loanMapper ) );

        return bookEntity.build();
    }

    @Override
    public List<DtoBook> toGetBookList(List<BookEntity> bookEntityList, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( bookEntityList == null ) {
            return null;
        }

        List<DtoBook> list = new ArrayList<DtoBook>( bookEntityList.size() );
        for ( BookEntity bookEntity : bookEntityList ) {
            list.add( toGetDTO( bookEntity, reservationMapper, loanMapper ) );
        }

        return list;
    }

    @Override
    public List<BookEntity> toEntityList(List<DtoBook> bookRequestList, ReservationMapper reservationMapper, LoanMapper loanMapper) {
        if ( bookRequestList == null ) {
            return null;
        }

        List<BookEntity> list = new ArrayList<BookEntity>( bookRequestList.size() );
        for ( DtoBook dtoBook : bookRequestList ) {
            list.add( toEntity( dtoBook, reservationMapper, loanMapper ) );
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

    protected DtoUser userEntityToDtoUser(UserEntity userEntity, ReservationMapper reservationMapper, LoanMapper loanMapper) {
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
        dtoUser.loans( loanListToDtoLoanList( userEntity.getLoans(), reservationMapper, loanMapper ) );

        return dtoUser.build();
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
        dtoLoan.user( userEntityToDtoUser( loan.getUser(), reservationMapper, loanMapper ) );
        dtoLoan.book( toGetDTO( loan.getBook(), reservationMapper, loanMapper ) );

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

    protected UserEntity dtoUserToUserEntity(DtoUser dtoUser, ReservationMapper reservationMapper, LoanMapper loanMapper) {
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
        userEntity.loans( dtoLoanListToLoanList( dtoUser.getLoans(), reservationMapper, loanMapper ) );

        return userEntity.build();
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
        loan.user( dtoUserToUserEntity( dtoLoan.getUser(), reservationMapper, loanMapper ) );
        loan.book( toEntity( dtoLoan.getBook(), reservationMapper, loanMapper ) );

        return loan.build();
    }
}
