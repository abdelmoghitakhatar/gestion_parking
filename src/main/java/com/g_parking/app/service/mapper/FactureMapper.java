package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.FactureEntity;
import com.g_parking.app.domain.ReservationEntity;
import com.g_parking.app.dto.FactureDTO;
import com.g_parking.app.dto.ReservationDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface FactureMapper extends EntityMapper<FactureDTO, FactureEntity>{

}
