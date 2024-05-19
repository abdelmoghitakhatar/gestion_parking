package com.g_parking.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class ReservationEntity implements Serializable {

  @Serial
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static final long serialVersionUID = -6100591526098454505L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(unique = true)
  private String numReservation;

  @NotNull
  private boolean canceled = false;

  @NotNull
  private LocalDateTime dateDebut;

  @NotNull
  private LocalDateTime dateFin;

  @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnoreProperties(value = {"reservation"})
  private FactureEntity facture;

  @ManyToOne
  @JsonIgnoreProperties(value = {"reservations", "vehicles"})
  private UserEntity user;

  @ManyToOne
  @JsonIgnoreProperties(value = {"reservations"})
  private ParkingEntity parking;
}
