package com.g_parking.app.dto.customResponse;

import com.g_parking.app.dto.UserDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserResponse implements Serializable {

    @Serial
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = -2210159572741327166L;

    private String generatedId;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 3, max = 25)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 25)
    private String lastName;

    public UserResponse dtoToResponse(UserDTO userDTO){
        this.setGeneratedId(userDTO.getGeneratedId());
        this.setEmail(userDTO.getEmail());
        this.setFirstName(userDTO.getFirstName());
        this.setLastName(userDTO.getLastName());
        return this;
    }
}
