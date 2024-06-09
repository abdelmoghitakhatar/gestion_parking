package com.g_parking.app.dto;

import com.g_parking.app.domain.enumeration.ErrorConstants;
import com.g_parking.app.domain.enumeration.PermitsType;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ParkingDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 2412397633760864888L;

  private Long id;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  private int numPlace;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  private PermitsType typePlace;

  private Set<ReservationDTO> reservations = new HashSet<>();

  public Set<ReservationDTO> getReservations() {
    return reservations;
  }

  public void setReservations(Set<ReservationDTO> reservations) {
    this.reservations = reservations;
  }

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
