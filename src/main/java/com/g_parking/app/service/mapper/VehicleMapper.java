package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.VehicleEntity;
import com.g_parking.app.dto.VehicleDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface VehicleMapper extends EntityMapper<VehicleDTO, VehicleEntity>{
}
