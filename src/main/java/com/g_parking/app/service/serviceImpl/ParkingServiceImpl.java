package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.domain.ParkingEntity;
import com.g_parking.app.domain.enumeration.ErrorMessage;
import com.g_parking.app.dto.ParkingDTO;
import com.g_parking.app.repository.ParkingRepository;
import com.g_parking.app.service.ParkingService;
import com.g_parking.app.service.mapper.ParkingMapper;
import com.g_parking.app.web.exceptions.ParkingException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {

  private final ParkingRepository parkingRepository;
  private final ParkingMapper parkingMapper;

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
  public ParkingDTO addPlace(ParkingDTO parking) throws ParkingException {

    if(parkingRepository.findByNumPlace(parking.getNumPlace()) != null){
      throw new ParkingException(ErrorMessage.NUM_PLACE_ALEADY_EXISTS.getMessage());
    }
    ParkingEntity place = parkingMapper.toEntity(parking);
    place = parkingRepository.save(place);
    return parkingMapper.toDto(place);
  }

  @Override
  public void removePlace(int numPlace) throws ParkingException {

    if(parkingRepository.findByNumPlace(numPlace) == null){
      throw new ParkingException(ErrorMessage.PLACE_NOT_FOUND.getMessage());
    }
    parkingRepository.deleteByNumPlace(numPlace);
  }

  @Override
  public ParkingDTO updatePlace(ParkingDTO parking) throws ParkingException {

    if(parkingRepository.findByNumPlace(parking.getNumPlace()) == null){
      throw new ParkingException(ErrorMessage.PLACE_NOT_FOUND.getMessage());
    }
    ParkingEntity place = parkingMapper.toEntity(parking);
    place = parkingRepository.save(place);
    return parkingMapper.toDto(place);
  }

  @Override
  public ParkingDTO getParkingByNumPlace(int numPlace){
    ParkingDTO parkingDTO = parkingMapper.toDto(
      parkingRepository.findByNumPlace(numPlace)
    );
   return parkingDTO;
  }
}
