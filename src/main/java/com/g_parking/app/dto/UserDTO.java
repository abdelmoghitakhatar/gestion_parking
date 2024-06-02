package com.g_parking.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 8051133884476414164L;

  private Long id;

  private String userName;

//  @NotNull
 // @Email
//  @Size(min = 5, max = 254)
  private String email;

 // @NotNull
 // @Size(min = 3, max = 25)
  private String firstName;

  //@NotNull
 // @Size(min = 3, max = 25)
  private String lastName;

//  @NotNull
  private String password;

//  @NotNull
//  @Pattern(regexp = "^((\\+)212|0|00212)[5-8](\\d{2}){4}$")
  private String phone;

  private String address;

  private Set<VehicleDTO> vehicles = new HashSet<>();

  private Set<ReservationDTO> Reservations = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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
}
