package com.g_parking.app.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
public class UserEntity implements Serializable {

    @Serial
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = -4237606748612106119L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true, nullable = false)
    private String generatedId;

    @Email
    @NotNull
    @Size(min = 5, max = 254)
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Size(min = 3, max = 25)
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 25)
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private String password;
}
