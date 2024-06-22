package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.domain.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-22T12:13:34-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toGetDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        if ( user.getIdUser() != null ) {
            userResponse.idUser( user.getIdUser() );
        }
        userResponse.fullName( user.getFullName() );
        userResponse.username( user.getUsername() );
        userResponse.email( user.getEmail() );
        userResponse.role( user.getRole() );

        return userResponse.build();
    }

    @Override
    public UserEntity toEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( request.getIdUser() );
        userEntity.username( request.getUsername() );
        userEntity.password( request.getPassword() );
        userEntity.email( request.getEmail() );
        userEntity.fullName( request.getFullName() );
        userEntity.role( request.getRole() );

        return userEntity.build();
    }

    @Override
    public void updateEntityFromDto(UserRequest dto, UserEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setIdUser( dto.getIdUser() );
        entity.setUsername( dto.getUsername() );
        entity.setPassword( dto.getPassword() );
        entity.setEmail( dto.getEmail() );
        entity.setFullName( dto.getFullName() );
        entity.setRole( dto.getRole() );
    }
}
