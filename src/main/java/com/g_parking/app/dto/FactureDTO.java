package com.g_parking.app.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class FactureDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = -2242432126336827712L;

  private Long id;

  @NotNull
  private LocalDate dateFacture = LocalDate.now();

  @NotNull
  private String numeroFacture;

  @NotNull
  private float montant;

  private ReservationDTO reservation;

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

  public ReservationDTO getReservation() {
    return reservation;
  }

  public void setReservation(ReservationDTO reservation) {
    this.reservation = reservation;
  }
}
