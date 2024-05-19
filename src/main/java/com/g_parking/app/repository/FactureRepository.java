package com.g_parking.app.repository;

import com.g_parking.app.domain.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<FactureEntity, Long> {
}
