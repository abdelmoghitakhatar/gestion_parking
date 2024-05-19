package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.ParkingEntity;
import com.g_parking.app.dto.ParkingDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParkingMapper extends EntityMapper<ParkingDTO, ParkingEntity>{
}
