package com.g_parking.app.web.controller;

import com.g_parking.app.dto.ReservationDTO;
import com.g_parking.app.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

  private final ReservationService reservationService;

  public ReservationController(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @PostMapping("/add")
  public ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationDTO reservationDTO){
    reservationDTO = reservationService.addReservation(reservationDTO);
    return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
  }

  @PostMapping("/add-payed")
  public ResponseEntity<ReservationDTO> payReservation(@RequestBody ReservationDTO reservationDTO){
    reservationDTO = reservationService.addPayedReservation(reservationDTO);
    return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
  }

  @PostMapping("/pay-exist/{numReservation}")
  public ResponseEntity<ReservationDTO> payExistReservation(@PathVariable String numReservation){
    ReservationDTO reservationDTO = reservationService.addFactureForExistReservation(numReservation);
    return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
  }

  @PutMapping("/cancel-reservation/{numReservation}")
  public ResponseEntity<String> cancelReservation(@PathVariable String numReservation){
    reservationService.cancelReservation(numReservation);
    return new ResponseEntity<>(numReservation, HttpStatus.OK);
  }
}
