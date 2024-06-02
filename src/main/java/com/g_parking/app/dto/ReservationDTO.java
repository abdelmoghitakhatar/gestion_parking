package com.g_parking.app.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ReservationDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 4402279045616248349L;

  private Long id;

  //@NotNull
  private String numReservation;

 // @NotNull
  private boolean canceled = false;

  //@NotNull
  private LocalDateTime dateDebut;

  //@NotNull
  private LocalDateTime dateFin;

  private FactureDTO facture;

  private UserDTO user;

  private ParkingDTO parking;

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

  public FactureDTO getFacture() {
    return facture;
  }

  public void setFacture(FactureDTO facture) {
    this.facture = facture;
  }

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public ParkingDTO getParking() {
    return parking;
  }

  public void setParking(ParkingDTO parking) {
    this.parking = parking;
  }
}
