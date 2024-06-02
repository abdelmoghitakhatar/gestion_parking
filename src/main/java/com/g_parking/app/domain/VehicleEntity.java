package com.g_parking.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.g_parking.app.domain.enumeration.VehicleName;
import com.g_parking.app.domain.enumeration.PermitsType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class VehicleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4273909107155547922L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @NotNull
  //  @Column(unique = true, nullable = false)
    private String matricule;

   // @NotNull
    @Enumerated(EnumType.STRING)
   // @Column(nullable = false)
    private VehicleName vehicleName;

  //  @NotNull
    @Enumerated(EnumType.STRING)
    //@Column(nullable = false)
    private PermitsType permitsType;

    @ManyToOne
    @JsonIgnoreProperties(value = {"vehicles", "Reservations"})
    private UserEntity user;

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

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }
}
