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
    date = "2024-06-21T19:10:56-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public DtoUser toGetDTO(UserEntity user) {
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

        return dtoUser.build();
    }

    @Override
    public UserEntity toEntity(DtoUser getUser) {
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
        userEntity.loans( dtoLoanListToLoanList( getUser.getLoans() ) );

        return userEntity.build();
    }

    @Override
    public List<DtoUser> toGetUserList(List<UserEntity> userList) {
        if ( userList == null ) {
            return null;
        }

        List<DtoUser> list = new ArrayList<DtoUser>( userList.size() );
        for ( UserEntity userEntity : userList ) {
            list.add( toGetDTO( userEntity ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toEntityList(List<DtoUser> userRequestList) {
        if ( userRequestList == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( userRequestList.size() );
        for ( DtoUser dtoUser : userRequestList ) {
            list.add( toEntity( dtoUser ) );
        }

        return list;
    }

    protected List<Loan> dtoLoanListToLoanList(List<DtoLoan> list) {
        if ( list == null ) {
            return null;
        }

        List<Loan> list1 = new ArrayList<Loan>( list.size() );
        for ( DtoLoan dtoLoan : list ) {
            list1.add( dtoLoanToLoan( dtoLoan ) );
        }

        return list1;
    }

    protected BookEntity dtoBookToBookEntity(DtoBook dtoBook) {
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
        bookEntity.loans( dtoLoanListToLoanList( dtoBook.getLoans() ) );

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
        loan.user( toEntity( dtoLoan.getUser() ) );
        loan.book( dtoBookToBookEntity( dtoLoan.getBook() ) );

        return loan.build();
    }
}
