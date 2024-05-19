package com.g_parking.app.dto;

import com.g_parking.app.domain.UserEntity;
import com.g_parking.app.domain.enumeration.PermitsType;
import com.g_parking.app.domain.enumeration.VehicleName;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Data
public class VehicleDTO implements Serializable {

    @Serial
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = -2954593831300966870L;

    private Long id;

    @NotNull
    private String matricule;

    @NotNull
    private VehicleName vehicleName;

    @NotNull
    private PermitsType permitsType;

    private UserEntity user;

}
