package com.example.librosYa.application.mappers;

import com.example.librosYa.application.dto.request.UserRequest;
import com.example.librosYa.application.dto.response.UserResponse;
import com.example.librosYa.domain.entities.UserEntity;
import org.mapstruct.*;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserResponse toGetDTO(UserEntity user);

    @InheritInverseConfiguration
    UserEntity toEntity(UserRequest request);

    void updateEntityFromDto(UserRequest dto, @MappingTarget UserEntity entity);

}

