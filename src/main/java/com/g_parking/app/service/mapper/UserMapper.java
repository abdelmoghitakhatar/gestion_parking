package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.dto.UserDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, UserEntity> {
}
