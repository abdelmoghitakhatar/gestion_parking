package com.g_parking.app.domain;

import com.g_parking.app.domain.enumeration.PermitsType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class ParkingEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = -2352722981736498977L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private int numPlace;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
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
