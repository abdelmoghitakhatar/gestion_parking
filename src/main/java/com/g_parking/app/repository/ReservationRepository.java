package com.g_parking.app.repository;

import com.g_parking.app.domain.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

  ReservationEntity findByNumReservation(String numReservation);

  @Modifying
  @Query("UPDATE ReservationEntity r SET r.canceled = true WHERE r.numReservation = :num")
  void annulerReservation(@Param("num") String numReservation);

  @Query("SELECT MAX(r.numReservation) FROM ReservationEntity r WHERE r.numReservation LIKE :pattern")
  Optional<String> getMaxNumeroReservation(@Param("pattern") String pattern);
}
