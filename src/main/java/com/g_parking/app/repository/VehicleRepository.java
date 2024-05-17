package com.g_parking.app.repository;

import com.g_parking.app.domain.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    Optional<VehicleEntity> findVehicleEntityByMatricule(String matricule);

    //  Optional<List<VehicleEntity>> findVehicleEntityByUserId(String matricule);

    void deleteByMatricule(String matricule);

}
