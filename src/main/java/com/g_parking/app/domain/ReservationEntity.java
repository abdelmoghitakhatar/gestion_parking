package com.g_parking.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class ReservationEntity implements Serializable {

  @Serial
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
  @JsonIgnoreProperties(value = {"reservation"}, allowSetters = true)
  private FactureEntity facture;

  @ManyToOne
  @JsonIgnoreProperties(value = {"reservations", "vehicles"})
  private UserEntity user;

  @ManyToOne
  @JsonIgnoreProperties(value = {"reservations"}, allowSetters = true)
  private ParkingEntity parking;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumReservation() {
    return numReservation;
  }

  public void setNumReservation(String numReservation) {
    this.numReservation = numReservation;
  }

  public boolean isCanceled() {
    return canceled;
  }

  public void setCanceled(boolean canceled) {
    this.canceled = canceled;
  }

  public LocalDateTime getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(LocalDateTime dateDebut) {
    this.dateDebut = dateDebut;
  }

  public LocalDateTime getDateFin() {
    return dateFin;
  }

  public void setDateFin(LocalDateTime dateFin) {
    this.dateFin = dateFin;
  }

  public FactureEntity getFacture() {
    return facture;
  }

  public void setFacture(FactureEntity facture) {
    this.facture = facture;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public ParkingEntity getParking() {
    return parking;
  }

  public void setParking(ParkingEntity parking) {
    this.parking = parking;
  }
}
