package com.g_parking.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.g_parking.app.domain.enumeration.VehicleName;
import com.g_parking.app.domain.enumeration.PermitsType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
public class VehicleEntity implements Serializable {

    @Serial
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = -4273909107155547922L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String matricule;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleName vehicleName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermitsType permitsType;

    @ManyToOne
    @JsonIgnoreProperties(value = {"vehicles", "Reservations"})
    private UserEntity user;
}
