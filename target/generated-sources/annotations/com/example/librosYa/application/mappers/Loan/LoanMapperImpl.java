package com.example.librosYa.application.mappers.Loan;

import com.example.librosYa.application.dto.request.BookRequest;
import com.example.librosYa.application.dto.request.LoanRequest;
import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.BookResponse;
import com.example.librosYa.application.dto.response.LoanResponse;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.domain.entities.BookEntity;
import com.example.librosYa.domain.entities.LoanEntity;
import com.example.librosYa.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T18:22:41-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class LoanMapperImpl implements LoanMapper {

    @Override
    public LoanEntity toEntity(LoanRequest request) {
        if ( request == null ) {
            return null;
        }

        LoanEntity.LoanEntityBuilder loanEntity = LoanEntity.builder();

        loanEntity.book( bookRequestToBookEntity( request.getBook() ) );
        loanEntity.date( request.getDate() );
        loanEntity.idLoan( request.getIdLoan() );
        loanEntity.returnDate( request.getReturnDate() );
        loanEntity.status( request.getStatus() );
        loanEntity.user( userRequestToUserEntity( request.getUser() ) );

        return loanEntity.build();
    }

    @Override
    public LoanResponse toResponse(LoanEntity loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponse.LoanResponseBuilder loanResponse = LoanResponse.builder();

        loanResponse.book( bookEntityToBookResponse( loan.getBook() ) );
        loanResponse.date( loan.getDate() );
        loanResponse.idLoan( loan.getIdLoan() );
        loanResponse.returnDate( loan.getReturnDate() );
        loanResponse.status( loan.getStatus() );
        loanResponse.user( userEntityToUserResponse( loan.getUser() ) );

        return loanResponse.build();
    }

    @Override
    public List<LoanResponse> toGetLoanList(List<LoanEntity> loanList) {
        if ( loanList == null ) {
            return null;
        }

        List<LoanResponse> list = new ArrayList<LoanResponse>( loanList.size() );
        for ( LoanEntity loanEntity : loanList ) {
            list.add( toResponse( loanEntity ) );
        }

        return list;
    }

    @Override
    public List<LoanEntity> toEntityList(List<LoanRequest> loanRequestList) {
        if ( loanRequestList == null ) {
            return null;
        }

        List<LoanEntity> list = new ArrayList<LoanEntity>( loanRequestList.size() );
        for ( LoanRequest loanRequest : loanRequestList ) {
            list.add( toEntity( loanRequest ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(LoanRequest dto, LoanEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getBook() != null ) {
            if ( entity.getBook() == null ) {
                entity.setBook( BookEntity.builder().build() );
            }
            bookRequestToBookEntity1( dto.getBook(), entity.getBook() );
        }
        else {
            entity.setBook( null );
        }
        entity.setDate( dto.getDate() );
        entity.setIdLoan( dto.getIdLoan() );
        entity.setReturnDate( dto.getReturnDate() );
        entity.setStatus( dto.getStatus() );
        if ( dto.getUser() != null ) {
            if ( entity.getUser() == null ) {
                entity.setUser( UserEntity.builder().build() );
            }
            userRequestToUserEntity1( dto.getUser(), entity.getUser() );
        }
        else {
            entity.setUser( null );
        }
    }

    protected BookEntity bookRequestToBookEntity(BookRequest bookRequest) {
        if ( bookRequest == null ) {
            return null;
        }

        BookEntity.BookEntityBuilder bookEntity = BookEntity.builder();

        bookEntity.author( bookRequest.getAuthor() );
        bookEntity.genre( bookRequest.getGenre() );
        bookEntity.idBook( bookRequest.getIdBook() );
        bookEntity.isbn( bookRequest.getIsbn() );
        bookEntity.loans( toEntityList( bookRequest.getLoans() ) );
        bookEntity.publicationYear( bookRequest.getPublicationYear() );
        bookEntity.titleBook( bookRequest.getTitleBook() );

        return bookEntity.build();
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

    protected BookResponse bookEntityToBookResponse(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookResponse.BookResponseBuilder bookResponse = BookResponse.builder();

        bookResponse.genre( bookEntity.getGenre() );
        bookResponse.idBook( bookEntity.getIdBook() );
        bookResponse.isbn( bookEntity.getIsbn() );
        bookResponse.publicationYear( bookEntity.getPublicationYear() );
        bookResponse.titleBook( bookEntity.getTitleBook() );

        return bookResponse.build();
    }

    protected UserResponse userEntityToUserResponse(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.email( userEntity.getEmail() );
        userResponse.fullName( userEntity.getFullName() );
        if ( userEntity.getIdUser() != null ) {
            userResponse.idUser( userEntity.getIdUser() );
        }
        userResponse.role( userEntity.getRole() );
        userResponse.username( userEntity.getUsername() );

        return userResponse.build();
    }

    protected void bookRequestToBookEntity1(BookRequest bookRequest, BookEntity mappingTarget) {
        if ( bookRequest == null ) {
            return;
        }

        mappingTarget.setAuthor( bookRequest.getAuthor() );
        mappingTarget.setGenre( bookRequest.getGenre() );
        mappingTarget.setIdBook( bookRequest.getIdBook() );
        mappingTarget.setIsbn( bookRequest.getIsbn() );
        if ( mappingTarget.getLoans() != null ) {
            List<LoanEntity> list = toEntityList( bookRequest.getLoans() );
            if ( list != null ) {
                mappingTarget.getLoans().clear();
                mappingTarget.getLoans().addAll( list );
            }
            else {
                mappingTarget.setLoans( null );
            }
        }
        else {
            List<LoanEntity> list = toEntityList( bookRequest.getLoans() );
            if ( list != null ) {
                mappingTarget.setLoans( list );
            }
        }
        mappingTarget.setPublicationYear( bookRequest.getPublicationYear() );
        mappingTarget.setTitleBook( bookRequest.getTitleBook() );
    }

    protected void userRequestToUserEntity1(UserRequest userRequest, UserEntity mappingTarget) {
        if ( userRequest == null ) {
            return;
        }

        mappingTarget.setEmail( userRequest.getEmail() );
        mappingTarget.setFullName( userRequest.getFullName() );
        mappingTarget.setIdUser( userRequest.getIdUser() );
        mappingTarget.setPassword( userRequest.getPassword() );
        mappingTarget.setRole( userRequest.getRole() );
        mappingTarget.setUsername( userRequest.getUsername() );
    }
}
