package com.g_parking.app.dto;

import com.g_parking.app.domain.enumeration.PermitsType;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class ParkingDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 2412397633760864888L;

  private Long id;

  @NotNull
  private int numPlace;

  @NotNull
  private PermitsType typePlace;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getNumPlace() {
    return numPlace;
  }

  public void setNumPlace(int numPlace) {
    this.numPlace = numPlace;
  }

  public PermitsType getTypePlace() {
    return typePlace;
  }

  public void setTypePlace(PermitsType typePlace) {
    this.typePlace = typePlace;
  }
}
