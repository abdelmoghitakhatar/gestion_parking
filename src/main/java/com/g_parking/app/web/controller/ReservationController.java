package com.g_parking.app.web.controller;

import com.g_parking.app.domain.enumeration.ErrorMessage;
import com.g_parking.app.dto.ReservationDTO;
import com.g_parking.app.service.ReservationService;
import com.g_parking.app.web.exceptions.ReservationException;
import jakarta.validation.Valid;
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
  public ResponseEntity<ReservationDTO> addReservation(@RequestBody @Valid ReservationDTO reservationDTO) throws ReservationException {
    if(reservationDTO.getId() != null){
      throw new ReservationException(ErrorMessage.RESERVATION_NOT_ACCEPTED.getMessage());
    }
    reservationDTO = reservationService.addReservation(reservationDTO);
    return new ResponseEntity<>(reservationDTO, HttpStatus.CREATED);
  }

  @PostMapping("/add-payed")
  public ResponseEntity<ReservationDTO> payedReservation(@RequestBody @Valid ReservationDTO reservationDTO){
    if(reservationDTO.getId() != null){
      throw new ReservationException(ErrorMessage.RESERVATION_NOT_ACCEPTED.getMessage());
    }
    reservationDTO = reservationService.addPayedReservation(reservationDTO);
    return new ResponseEntity<>(reservationDTO, HttpStatus.CREATED);
  }

  @PutMapping("/pay-exist/{numReservation}")
  public ResponseEntity<ReservationDTO> payExistReservation(@PathVariable String numReservation){
    ReservationDTO reservationDTO = reservationService.addFactureForExistReservation(numReservation);
    return new ResponseEntity<>(reservationDTO, HttpStatus.ACCEPTED);
  }

  @PutMapping("/cancel-reservation/{numReservation}")
  public ResponseEntity<String> cancelReservation(@PathVariable String numReservation){
    reservationService.cancelReservation(numReservation);
    return new ResponseEntity<>(numReservation, HttpStatus.ACCEPTED);
  }
}
