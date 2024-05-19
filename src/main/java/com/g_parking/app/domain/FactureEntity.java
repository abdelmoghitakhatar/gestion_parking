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
import java.time.LocalDate;

@Data
@Entity
public class FactureEntity implements Serializable {

  @Serial
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static final long serialVersionUID = -6100591526098454505L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private LocalDate dateFacture = LocalDate.now();

  @NotNull
  private String numeroFacture;

  @NotNull
  private float montant;

  @OneToOne
  @JsonIgnoreProperties(value = {"facture"})
  private ReservationEntity reservation;
}
