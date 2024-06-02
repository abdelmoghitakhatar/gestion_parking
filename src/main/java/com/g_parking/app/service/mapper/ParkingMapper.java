package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.ParkingEntity;
import com.g_parking.app.domain.ReservationEntity;
import com.g_parking.app.dto.ParkingDTO;
import com.g_parking.app.dto.ReservationDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ParkingMapper extends EntityMapper<ParkingDTO, ParkingEntity>{

  @Mapping(source = "reservations", target = "reservations", qualifiedByName = "reservations")
  ParkingDTO toDto(ParkingEntity parking);

  @BeanMapping(ignoreByDefault = true)
  @Mapping(source = "dateDebut", target = "dateDebut")
  @Mapping(source = "dateFin", target = "dateFin")
  ReservationDTO toDtoReservation(ReservationEntity reservation);

  @Named("reservations")
  default Set<ReservationDTO> toDtoReservationSet(Set<ReservationEntity> reservations){
    return reservations.stream().map(this::toDtoReservation).collect(Collectors.toSet());
  }
}
