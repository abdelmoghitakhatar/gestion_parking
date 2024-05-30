package com.g_parking.app.web.controller;

import com.g_parking.app.dto.ParkingDTO;
import com.g_parking.app.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
