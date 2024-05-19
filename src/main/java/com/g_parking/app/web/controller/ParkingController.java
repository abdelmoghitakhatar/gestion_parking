package com.g_parking.app.web.controller;

import com.g_parking.app.service.ParkingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
public class ParkingController {

  private ParkingService parkingService;

  public ParkingController(ParkingService parkingService) {
    this.parkingService = parkingService;
  }
}
