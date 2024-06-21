package com.example.librosYa.util.mappers;

import com.example.librosYa.api.dto.DtoUser;
import com.example.librosYa.domain.entities.UserEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ReservationMapper.class,LoanMapper.class})
public interface UserMapper {


    DtoUser toGetDTO(UserEntity user, @Context ReservationMapper reservationMapper, @Context LoanMapper loanMapper);

    @InheritInverseConfiguration
    UserEntity toEntity(DtoUser getUser, @Context ReservationMapper reservationMapper, @Context LoanMapper loanMapper);

    List<DtoUser> toGetUserList(List<UserEntity> userList, @Context ReservationMapper reservationMapper, @Context LoanMapper loanMapper);

    List<UserEntity> toEntityList(List<DtoUser> userRequestList, @Context ReservationMapper reservationMapper, @Context LoanMapper loanMapper);
}
