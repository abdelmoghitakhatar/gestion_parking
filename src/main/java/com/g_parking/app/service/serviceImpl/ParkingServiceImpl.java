package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.domain.ParkingEntity;
import com.g_parking.app.dto.ParkingDTO;
import com.g_parking.app.repository.ParkingRepository;
import com.g_parking.app.service.ParkingService;
import com.g_parking.app.service.mapper.ParkingMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {

  private ParkingRepository parkingRepository;
  private ParkingMapper parkingMapper;

  public ParkingServiceImpl(ParkingRepository parkingRepository, ParkingMapper parkingMapper) {
    this.parkingRepository = parkingRepository;
    this.parkingMapper = parkingMapper;
  }

  @Override
  public Set<ParkingDTO> findAll() {

    Set<ParkingDTO> parkings = parkingRepository.findAll()
      .stream()
      .map(parkingMapper::toDto)
      .collect(Collectors.toSet());

    return parkings;
  }

  @Override
  public Set<ParkingDTO> getFreePlaces(LocalDateTime dateDebut, LocalDateTime dateFin) {

    Set<ParkingDTO> parkings = parkingRepository.getPlacesByTime(dateDebut, dateFin)
      .stream()
      .map(parkingMapper::toDto)
      .collect(Collectors.toSet());

    return parkings;
  }

  @Override
  public ParkingDTO addPlace(ParkingDTO parking) {
    ParkingEntity place = parkingMapper.toEntity(parking);
    place = parkingRepository.save(place);
    return parkingMapper.toDto(place);
  }
}
