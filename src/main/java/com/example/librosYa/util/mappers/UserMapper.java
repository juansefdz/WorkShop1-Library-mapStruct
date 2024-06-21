package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoUser;
import com.example.librosYa.domain.entities.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ReservationMapper.class,LoanMapper.class})
public interface UserMapper {


    DtoUser toGetDTO(UserEntity user);

    @InheritInverseConfiguration
    UserEntity toEntity(DtoUser getUser);
    List<DtoUser> toGetUserList (List<UserEntity> userList);
    List<UserEntity> toEntityList(List<DtoUser> userRequestList);
}
