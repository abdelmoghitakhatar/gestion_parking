package com.g_parking.app.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
public class UserDTO implements Serializable {

  @Serial
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private static final long serialVersionUID = 8051133884476414164L;

  private Long id;

  private String userName;

  @NotNull
  @Email
  @Size(min = 5, max = 254)
  private String email;

  @NotNull
  @Size(min = 3, max = 25)
  private String firstName;

  @NotNull
  @Size(min = 3, max = 25)
  private String lastName;

  @NotNull
  private String password;

  @NotNull
  @Pattern(regexp = "^((\\+)212|0|00212)[5-8](\\d{2}){4}$")
  private String phone;

  private String address;

  private Set<VehicleDTO> vehicles;

  private Set<ReservationDTO> Reservations;
}
