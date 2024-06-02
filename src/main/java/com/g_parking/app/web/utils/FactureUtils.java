package com.g_parking.app.web.utils;

import com.g_parking.app.domain.enumeration.PermitsType;
import com.g_parking.app.dto.FactureDTO;
import com.g_parking.app.dto.ReservationDTO;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

@Component
public class FactureUtils {

  public FactureDTO generateFacture(ReservationDTO reservation){

    FactureDTO facture = reservation.getFacture() != null ? reservation.getFacture() : new FactureDTO();

    long duree = Duration.between(reservation.getDateDebut(), reservation.getDateFin()).toHours();

    facture.setMontant(duree * getPricePerHour(reservation.getParking().getTypePlace()));
    facture.setDateFacture(LocalDate.now());
    facture.setNumeroFacture(String.valueOf(new Random().nextInt(999999999)));//TODO:adapt numFacture with real generated number

    return facture;
  }

  public int getPricePerHour(PermitsType type){
    // TODO : to add filter to get the price of each place
    return 5;
  }
}
