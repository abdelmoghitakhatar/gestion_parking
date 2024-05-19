package com.g_parking.app.web.controller;

import com.g_parking.app.service.ReservationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

  private ReservationService reservationService;

  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }
}
