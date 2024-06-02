package com.g_parking.app.web.controller;

import com.g_parking.app.dto.ParkingDTO;
import com.g_parking.app.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/parking")
public class ParkingController {

  private final ParkingService parkingService;

  public ParkingController(ParkingService parkingService) {
    this.parkingService = parkingService;
  }

  @GetMapping()
  public Set<ParkingDTO> getAllParking(){
    return parkingService.findAll();
  }

  @GetMapping("/free-places")
  public Set<ParkingDTO> getFreePlaces(@RequestParam LocalDateTime dateDebut, @RequestParam LocalDateTime dateFin){
    return parkingService.getFreePlaces(dateDebut, dateFin);
  }
}
