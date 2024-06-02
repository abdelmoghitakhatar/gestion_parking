package com.g_parking.app.service;

import com.g_parking.app.dto.FactureDTO;
import com.g_parking.app.dto.ReservationDTO;

public interface ReservationService {

  ReservationDTO addReservation(ReservationDTO reservationDTO);

  ReservationDTO addPayedReservation(ReservationDTO reservationDTO);

  ReservationDTO addFactureForExistReservation(String numReservation);

}
