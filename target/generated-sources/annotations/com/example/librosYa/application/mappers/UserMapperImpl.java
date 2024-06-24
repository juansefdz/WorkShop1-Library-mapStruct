package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.domain.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-23T19:46:58-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toGetDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.email( user.getEmail() );
        userResponse.fullName( user.getFullName() );
        if ( user.getIdUser() != null ) {
            userResponse.idUser( user.getIdUser() );
        }
        userResponse.role( user.getRole() );
        userResponse.username( user.getUsername() );

        return userResponse.build();
    }

    @Override
    public UserEntity toEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.email( request.getEmail() );
        userEntity.fullName( request.getFullName() );
        userEntity.idUser( request.getIdUser() );
        userEntity.password( request.getPassword() );
        userEntity.role( request.getRole() );
        userEntity.username( request.getUsername() );

        return userEntity.build();
    }

    @Override
    public void updateEntityFromDto(UserRequest dto, UserEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setEmail( dto.getEmail() );
        entity.setFullName( dto.getFullName() );
        entity.setIdUser( dto.getIdUser() );
        entity.setPassword( dto.getPassword() );
        entity.setRole( dto.getRole() );
        entity.setUsername( dto.getUsername() );
    }
}
