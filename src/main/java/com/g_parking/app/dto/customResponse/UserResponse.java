package com.g_parking.app.dto.customResponse;

import com.g_parking.app.dto.ReservationDTO;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.dto.VehicleDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -2210159572741327166L;

    private String userName;

  //  @NotNull
    private String email;

 //   @NotNull
  //  @Size(min = 3, max = 25)
    private String firstName;

 //   @NotNull
  //  @Size(min = 3, max = 25)
    private String lastName;

    private Set<VehicleDTO> vehicles = new HashSet<>();

    private Set<ReservationDTO> Reservations = new HashSet<>();


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<VehicleDTO> getVehicles() {
    return vehicles;
  }

  public void setVehicles(Set<VehicleDTO> vehicles) {
    this.vehicles = vehicles;
  }

  public Set<ReservationDTO> getReservations() {
    return Reservations;
  }

  public void setReservations(Set<ReservationDTO> reservations) {
    Reservations = reservations;
  }

  public UserResponse dtoToResponse(UserDTO userDTO){
    this.setUserName(userDTO.getUserName());
    this.setEmail(userDTO.getEmail());
    this.setFirstName(userDTO.getFirstName());
    this.setLastName(userDTO.getLastName());
    this.setVehicles(userDTO.getVehicles());
    this.setReservations(userDTO.getReservations());
    return this;
    }
}
