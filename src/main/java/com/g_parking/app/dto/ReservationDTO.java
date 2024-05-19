package com.g_parking.app.dto;

import com.g_parking.app.domain.FactureEntity;
import com.g_parking.app.domain.ParkingEntity;
import com.g_parking.app.domain.UserEntity;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ReservationDTO implements Serializable {

  @Serial
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static final long serialVersionUID = 4402279045616248349L;

  private Long id;

  @NotNull
  private String numReservation;

  @NotNull
  private boolean canceled = false;

  @NotNull
  private LocalDateTime dateDebut;

  @NotNull
  private LocalDateTime dateFin;

  private FactureEntity facture;

  private UserEntity user;

  private ParkingEntity parking;
}
