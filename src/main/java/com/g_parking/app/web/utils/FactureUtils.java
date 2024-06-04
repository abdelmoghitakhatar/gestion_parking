package com.g_parking.app.web.utils;

import com.g_parking.app.domain.enumeration.PermitsType;
import com.g_parking.app.dto.FactureDTO;
import com.g_parking.app.dto.ReservationDTO;
import com.g_parking.app.repository.FactureRepository;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class FactureUtils {

  private final FactureRepository factureRepository;

  public FactureUtils(FactureRepository factureRepository) {
    this.factureRepository = factureRepository;
  }

  public FactureDTO generateFacture(ReservationDTO reservation){

    FactureDTO facture = reservation.getFacture() != null ? reservation.getFacture() : new FactureDTO();

    long duree = Duration.between(reservation.getDateDebut(), reservation.getDateFin()).toHours();

    facture.setMontant(duree * getPricePerHour(reservation.getParking().getTypePlace()));
    facture.setDateFacture(LocalDate.now());
    facture.setNumeroFacture(getNextNumeroFacture());

    return facture;
  }

  public float getPricePerHour(PermitsType type){
    return switch (type) {
      case AM, A1 -> 1;
      case A -> 1.5f;
      case B, EB -> 2.5f;
      case C -> 3;
      case EC -> 3.5f;
      case D -> 4.5f;
      case ED -> 5;
    };
  }

  public String getNextNumeroFacture() {
    Optional<String> max = factureRepository.getMaxNumeroFacture();
    if(max.isEmpty()){
      String numeroFacture = LocalDate.now()
        .format(
          DateTimeFormatter.ofPattern("yyyyMMdd")
        );
      return numeroFacture + "001";
    } else {
      return String.valueOf(Long.parseLong(max.get())+1);
    }
  }
}
