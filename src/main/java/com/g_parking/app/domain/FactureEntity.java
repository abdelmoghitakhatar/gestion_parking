package com.g_parking.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class FactureEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = -6100591526098454505L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

 // @NotNull
  private LocalDate dateFacture = LocalDate.now();

 // @NotNull
  private String numeroFacture;

  //@NotNull
  private float montant;

  @OneToOne
  @JsonIgnoreProperties(value = {"facture"}, allowSetters = true)
  private ReservationEntity reservation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDateFacture() {
    return dateFacture;
  }

  public void setDateFacture(LocalDate dateFacture) {
    this.dateFacture = dateFacture;
  }

  public String getNumeroFacture() {
    return numeroFacture;
  }

  public void setNumeroFacture(String numeroFacture) {
    this.numeroFacture = numeroFacture;
  }

  public float getMontant() {
    return montant;
  }

  public void setMontant(float montant) {
    this.montant = montant;
  }

  public ReservationEntity getReservation() {
    return reservation;
  }

  public void setReservation(ReservationEntity reservation) {
    this.reservation = reservation;
  }
}
