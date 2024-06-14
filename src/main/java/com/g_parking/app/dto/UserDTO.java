package com.g_parking.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.g_parking.app.domain.enumeration.ErrorConstants;
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

  @Email(message = ErrorConstants.EMAIL_ERROR)
  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 5, message = ErrorConstants.MIN_ERROR)
  @Size(max = 254, message = ErrorConstants.MAX_ERROR)
  private String email;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 3, message = ErrorConstants.MIN_ERROR)
  @Size(max = 25, message = ErrorConstants.MAX_ERROR)
  private String firstName;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 3, message = ErrorConstants.MIN_ERROR)
  @Size(max = 25, message = ErrorConstants.MAX_ERROR)
  private String lastName;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Pattern(regexp = "^((\\+)212|0|00212)[5-8](\\d{2}){4}$", message = ErrorConstants.PATTERN_ERROR)
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
