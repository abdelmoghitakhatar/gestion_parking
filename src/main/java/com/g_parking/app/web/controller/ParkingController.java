package com.g_parking.app.web.controller;

import com.g_parking.app.domain.enumeration.ErrorMessage;
import com.g_parking.app.dto.ParkingDTO;
import com.g_parking.app.service.ParkingService;
import com.g_parking.app.web.exceptions.ParkingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/parking")
public class ParkingController {

  private final ParkingService parkingService;

  public ParkingController(ParkingService parkingService) {
    this.parkingService = parkingService;
  }

  @GetMapping("/all")
  public ResponseEntity<Set<ParkingDTO>> getAllParking(){
    return new ResponseEntity<>(parkingService.findAll(), HttpStatus.OK);
  }

  @GetMapping("/free-places")
  public ResponseEntity<Set<ParkingDTO>> getFreePlaces(@RequestParam LocalDateTime dateDebut, @RequestParam LocalDateTime dateFin){
    return new ResponseEntity<>(parkingService.getFreePlaces(dateDebut, dateFin), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<ParkingDTO> addPlace(@RequestBody ParkingDTO parkingDTO) throws ParkingException {
    if (parkingDTO.getId() != null){
      throw new ParkingException(ErrorMessage.PLACE_NOT_ACCEPTED.getMessage());
    }
    return new ResponseEntity<>(parkingService.addPlace(parkingDTO), HttpStatus.OK);
  }

  @PutMapping("/edit/{numPlace}")
  public ResponseEntity<ParkingDTO> editPlace(@RequestBody ParkingDTO parkingDTO, @PathVariable int numPlace) throws ParkingException {
    if(numPlace != parkingDTO.getNumPlace() || parkingDTO.getId() == null){
      throw new ParkingException(ErrorMessage.UPDATE_NOT_ACCEPTED.getMessage());
    }
    if(parkingService.getParkingByNumPlace(numPlace) == null){
      throw new ParkingException(ErrorMessage.PLACE_NOT_FOUND.getMessage());
    }
    return new ResponseEntity<>(parkingService.updatePlace(parkingDTO), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{numPlace}")
  public void removePlace(@PathVariable int numPlace) throws ParkingException {
    if(parkingService.getParkingByNumPlace(numPlace) == null){
      throw new ParkingException(ErrorMessage.PLACE_NOT_FOUND.getMessage());
    }
    parkingService.removePlace(numPlace);
  }
}
