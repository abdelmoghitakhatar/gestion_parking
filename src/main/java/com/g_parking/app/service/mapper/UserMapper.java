package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.*;
import com.g_parking.app.dto.*;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, UserEntity> {

  @Mapping(source = "vehicles", target = "vehicles", qualifiedByName = "vehicleSet")
  @Mapping(source = "reservations", target = "reservations", qualifiedByName = "reservationSet")
  UserDTO toDto(UserEntity user);

  @BeanMapping(ignoreByDefault = true)
  @Mapping(source = "id", target = "id")
  @Mapping(source = "matricule", target = "matricule")
  @Mapping(source = "vehicleName", target = "vehicleName")
  @Mapping(source = "permitsType", target = "permitsType")
  VehicleDTO toDtoVehicle(VehicleEntity vehicle);

  @Named("vehicleSet")
  default Set<VehicleDTO> toDtoVehicles(Set<VehicleEntity> vehicles){
    return vehicles.stream().map(this::toDtoVehicle).collect(Collectors.toSet());
  }

  @Named("facture")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(source = "id", target = "id")
  @Mapping(source = "dateFacture", target = "dateFacture")
  @Mapping(source = "numeroFacture", target = "numeroFacture")
  @Mapping(source = "montant", target = "montant")
  FactureDTO toDtoFacture(FactureEntity facture);

  @Named("parking")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(source = "id", target = "id")
  @Mapping(source = "numPlace", target = "numPlace")
  @Mapping(source = "typePlace", target = "typePlace")
  ParkingDTO toDtoParking(ParkingEntity parking);

  @BeanMapping(ignoreByDefault = true)
  @Mapping(source = "id", target = "id")
  @Mapping(source = "numReservation", target = "numReservation")
  @Mapping(source = "canceled", target = "canceled")
  @Mapping(source = "dateDebut", target = "dateDebut")
  @Mapping(source = "dateFin", target = "dateFin")
  @Mapping(source = "facture", target = "facture", qualifiedByName = "facture")
  @Mapping(source = "parking", target = "parking", qualifiedByName = "parking")
  ReservationDTO toDtoReservation(ReservationEntity reservation);

  @Named("reservationSet")
  default Set<ReservationDTO> toDtoReservations(Set<ReservationEntity> reservations){
    return reservations.stream().map(this::toDtoReservation).collect(Collectors.toSet());
  }
}
