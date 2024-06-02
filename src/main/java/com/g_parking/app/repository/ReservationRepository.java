package com.g_parking.app.repository;

import com.g_parking.app.domain.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

  ReservationEntity findByNumReservation(String numReservation);

  @Query("UPDATE ReservationEntity r SET r.canceled = true WHERE r.numReservation = :num")
  ReservationEntity annulerReservation(@Param("num") String numReservation);
}
