package com.g_parking.app.dto.customResponse;

import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.dto.VehicleDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
public class UserResponse implements Serializable {

    @Serial
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = -2210159572741327166L;

    private String userName;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 3, max = 25)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 25)
    private String lastName;

    private Set<VehicleDTO> vehicles;

    public UserResponse dtoToResponse(UserDTO userDTO){
        this.setUserName(userDTO.getUserName());
        this.setEmail(userDTO.getEmail());
        this.setFirstName(userDTO.getFirstName());
        this.setLastName(userDTO.getLastName());
        this.setVehicles(userDTO.getVehicles());
        return this;
    }
}
