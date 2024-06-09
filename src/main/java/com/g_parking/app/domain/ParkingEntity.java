package com.g_parking.app.domain;

import com.g_parking.app.domain.enumeration.ErrorConstants;
import com.g_parking.app.domain.enumeration.PermitsType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ParkingEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = -2352722981736498977L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Column(unique = true, nullable = false)
  private int numPlace;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private PermitsType typePlace;

  @OneToMany(mappedBy = "parking")
  private Set<ReservationEntity> reservations = new HashSet<>();

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

  public Set<ReservationEntity> getReservations() {
    return reservations;
  }

  public void setReservations(Set<ReservationEntity> reservations) {
    this.reservations = reservations;
  }
}
