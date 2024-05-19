package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.domain.VehicleEntity;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.dto.VehicleDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VehicleMapper extends EntityMapper<VehicleDTO, VehicleEntity>{

//  @Mapping(source = "user", target = "user", qualifiedByName = "userId")
//  VehicleDTO toDto(VehicleEntity vehicle);
//
//  @Named("userId")
//  @BeanMapping(ignoreByDefault = true)
//  @Mapping(source = "userName", target = "userName")
//  @Mapping(source = "email", target = "email")
//  @Mapping(source = "firstName", target = "firstName")
//  @Mapping(source = "lastName", target = "lastName")
//  UserDTO toDtoUserId(UserEntity user);
}
