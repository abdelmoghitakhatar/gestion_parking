package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.FactureEntity;
import com.g_parking.app.dto.FactureDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FactureMapper extends EntityMapper<FactureDTO, FactureEntity>{
}
