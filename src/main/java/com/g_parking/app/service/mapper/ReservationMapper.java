package com.g_parking.app.service.mapper;

import com.g_parking.app.domain.FactureEntity;
import com.g_parking.app.domain.ReservationEntity;
import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.dto.FactureDTO;
import com.g_parking.app.dto.ReservationDTO;
import com.g_parking.app.dto.UserDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReservationMapper extends EntityMapper<ReservationDTO, ReservationEntity>{

  @Mapping(source = "user", target = "user", qualifiedByName = "user")
  @Mapping(source = "facture", target = "facture", qualifiedByName = "facture")
  ReservationDTO toDto(ReservationEntity reservation);

  @Named("user")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(source = "userName", target = "userName")
  @Mapping(source = "email", target = "email")
  @Mapping(source = "firstName", target = "firstName")
  @Mapping(source = "lastName", target = "lastName")
  UserDTO toDtoUser(UserEntity user);

  @Named("facture")
  @BeanMapping(ignoreByDefault = true)
  @Mapping(source = "id", target = "id")
  @Mapping(source = "dateFacture", target = "dateFacture")
  @Mapping(source = "numeroFacture", target = "numeroFacture")
  @Mapping(source = "montant", target = "montant")
  FactureDTO toDtoFacture(FactureEntity facture);
}
