package com.g_parking.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -4237606748612106119L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
