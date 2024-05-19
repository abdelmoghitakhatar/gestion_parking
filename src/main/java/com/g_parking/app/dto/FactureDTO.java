package com.g_parking.app.dto;


import com.g_parking.app.domain.ReservationEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class FactureDTO implements Serializable {

  @Serial
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static final long serialVersionUID = -2242432126336827712L;

  private Long id;

  @NotNull
  private LocalDate dateFacture = LocalDate.now();

  @NotNull
  private String numeroFacture;

  @NotNull
  private float montant;

  private ReservationEntity reservation;
}
