package com.g_parking.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.g_parking.app.domain.enumeration.ErrorConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = -4237606748612106119L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Column(unique = true, nullable = false)
  private String userName;

  @Email(message = ErrorConstants.EMAIL_ERROR)
  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 5, message = ErrorConstants.MIN_ERROR)
  @Size(max = 254, message = ErrorConstants.MAX_ERROR)
  @Column(unique = true, nullable = false)
  private String email;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 3, message = ErrorConstants.MIN_ERROR)
  @Size(max = 25, message = ErrorConstants.MAX_ERROR)
  @Column(nullable = false)
  private String firstName;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 3, message = ErrorConstants.MIN_ERROR)
  @Size(max = 25, message = ErrorConstants.MAX_ERROR)
  @Column(nullable = false)
  private String lastName;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Size(min = 8, message = ErrorConstants.MIN_ERROR)
  @Column(nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  @Pattern(regexp = "^((\\+)212|0|00212)[5-8](\\d{2}){4}$", message = ErrorConstants.PATTERN_ERROR)
  @Column(unique = true, nullable = false)
  private String phone;

  private String address;

  @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
  private Set<VehicleEntity> vehicles = new HashSet<>();

  @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
  private Set<ReservationEntity> reservations = new HashSet<>();

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

  public Set<VehicleEntity> getVehicles() {
    return vehicles;
  }

  public void setVehicles(Set<VehicleEntity> vehicles) {
    if(vehicles != null) {
      vehicles.forEach(i -> i.setUser(this));
    }
    this.vehicles = vehicles;
  }

  public Set<ReservationEntity> getReservations() {
    return reservations;
  }

  public void setReservations(Set<ReservationEntity> reservations) {
    if(reservations != null) {
      reservations.forEach(i -> i.setUser(this));
    }
    this.reservations = reservations;
  }
}
