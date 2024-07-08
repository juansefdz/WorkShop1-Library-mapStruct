package com.example.librosYa.application.mappers.User;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;

import com.example.librosYa.domain.entities.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserEntity toEntity (UserRequest userRequest);

    @InheritInverseConfiguration
    UserResponse toResponse (UserEntity userEntity);

    List<UserEntity> toEntityList(List<UserRequest> request);

    List<UserResponse> toResponseList(List<UserEntity> entity);

    void updateEntityFromDto(UserRequest dto, @MappingTarget UserEntity entity);
}

