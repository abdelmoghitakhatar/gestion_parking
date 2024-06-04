package com.g_parking.app.repository;

import com.g_parking.app.domain.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<FactureEntity, Long> {

  @Query("SELECT MAX(f.numeroFacture) FROM FactureEntity f WHERE DATE(f.dateFacture) = CURDATE()")
  Optional<String> getMaxNumeroFacture();
}
