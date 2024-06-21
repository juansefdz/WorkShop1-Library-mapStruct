package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoUser;
import com.example.librosYa.domain.entities.UserEntity;
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
public class UserMapperImpl implements UserMapper {

    @Autowired
    private LoanMapper loanMapper;

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
        dtoUser.loans( loanMapper.toGetLoanList( user.getLoans() ) );

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
        userEntity.loans( loanMapper.toEntityLoanList( getUser.getLoans() ) );

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
}
