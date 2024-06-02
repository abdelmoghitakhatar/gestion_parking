package com.g_parking.app.repository;

import com.g_parking.app.domain.ParkingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Long> {

  @Query("SELECT p " +
    "FROM ParkingEntity p " +
    "WHERE p.id NOT IN " +
    " (SELECT r.parking.id FROM ReservationEntity r " +
    "WHERE (r.dateDebut <= :dateDebut AND r.dateFin >= :dateDebut) " +
    "OR (r.dateDebut <= :dateFin AND r.dateFin >= :dateFin))")
  Set<ParkingEntity> getPlacesByTime(@Param("dateDebut")LocalDateTime dateDebut, @Param("dateFin")LocalDateTime dateFin);

   void deleteByNumPlace(int numPlace);

}
