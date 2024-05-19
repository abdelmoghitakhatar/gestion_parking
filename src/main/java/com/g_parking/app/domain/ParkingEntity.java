package com.g_parking.app.domain;

import com.g_parking.app.domain.enumeration.PermitsType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class ParkingEntity implements Serializable {

  @Serial
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
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
}
