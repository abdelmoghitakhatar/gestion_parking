package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.ReservationEntity;
import com.g_parking.app.dto.ReservationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper extends EntityMapper<ReservationDTO, ReservationEntity>{
}
