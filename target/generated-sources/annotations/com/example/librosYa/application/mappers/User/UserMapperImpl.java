package com.example.librosYa.application.mappers.User;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.domain.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T18:22:42-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserRequest userRequest) {
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

    @Override
    public UserResponse toResponse(UserEntity userEntity) {
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

    @Override
    public List<UserEntity> toEntityList(List<UserRequest> request) {
        if ( request == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( request.size() );
        for ( UserRequest userRequest : request ) {
            list.add( toEntity( userRequest ) );
        }

        return list;
    }

    @Override
    public List<UserResponse> toResponseList(List<UserEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserResponse> list = new ArrayList<UserResponse>( entity.size() );
        for ( UserEntity userEntity : entity ) {
            list.add( toResponse( userEntity ) );
        }

        return list;
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
