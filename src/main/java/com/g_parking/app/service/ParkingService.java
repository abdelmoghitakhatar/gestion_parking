package com.g_parking.app.service;

import com.g_parking.app.dto.ParkingDTO;

import java.time.LocalDateTime;
import java.util.Set;

public interface ParkingService {

  Set<ParkingDTO> findAll();

  Set<ParkingDTO> getFreePlaces(LocalDateTime dateDebut, LocalDateTime dateFin);

  ParkingDTO addPlace(ParkingDTO parking);
}
