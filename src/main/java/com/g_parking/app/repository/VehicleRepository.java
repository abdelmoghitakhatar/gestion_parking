package com.g_parking.app.repository;

import com.g_parking.app.domain.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    Optional<VehicleEntity> findVehicleEntityByMatricule(String matricule);

    void deleteByMatricule(String matricule);

}
