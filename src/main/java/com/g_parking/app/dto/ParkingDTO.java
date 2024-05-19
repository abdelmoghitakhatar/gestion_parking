package com.g_parking.app.dto;

import com.g_parking.app.domain.enumeration.PermitsType;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ParkingDTO implements Serializable {

  @Serial
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static final long serialVersionUID = 2412397633760864888L;

  private Long id;

  @NotNull
  private int numPlace;

  @NotNull
  private PermitsType typePlace;
}
