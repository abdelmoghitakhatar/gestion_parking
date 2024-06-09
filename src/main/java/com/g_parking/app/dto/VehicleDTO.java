package com.g_parking.app.dto;

import com.g_parking.app.domain.enumeration.ErrorConstants;
import com.g_parking.app.domain.enumeration.PermitsType;
import com.g_parking.app.domain.enumeration.VehicleName;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class VehicleDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = -2954593831300966870L;

  private Long id;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  private String matricule;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  private VehicleName vehicleName;

  @NotNull(message = ErrorConstants.NULL_ERROR)
  private PermitsType permitsType;

  private UserDTO user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMatricule() {
    return matricule;
  }

  public void setMatricule(String matricule) {
    this.matricule = matricule;
  }

  public VehicleName getVehicleName() {
    return vehicleName;
  }

  public void setVehicleName(VehicleName vehicleName) {
    this.vehicleName = vehicleName;
  }

  public PermitsType getPermitsType() {
    return permitsType;
  }

  public void setPermitsType(PermitsType permitsType) {
    this.permitsType = permitsType;
  }

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }
}
