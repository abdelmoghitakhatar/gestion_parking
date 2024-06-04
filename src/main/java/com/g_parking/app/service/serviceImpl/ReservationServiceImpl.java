package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.domain.ReservationEntity;
import com.g_parking.app.dto.FactureDTO;
import com.g_parking.app.dto.ReservationDTO;
import com.g_parking.app.repository.ReservationRepository;
import com.g_parking.app.service.ReservationService;
import com.g_parking.app.service.mapper.ReservationMapper;
import com.g_parking.app.web.utils.FactureUtils;
import com.g_parking.app.web.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

  private final ReservationRepository reservationRepository;
  private final ReservationMapper reservationMapper;
  private final FactureUtils factureUtils;
  private final UserUtils userUtils;

  public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, FactureUtils factureUtils, UserUtils userUtils) {
    this.reservationRepository = reservationRepository;
    this.reservationMapper = reservationMapper;
    this.factureUtils = factureUtils;
    this.userUtils = userUtils;
  }

  @Override
  public ReservationDTO addReservation(ReservationDTO reservationDTO) {
    reservationDTO.setUser(userUtils.getConnectedUser());
    reservationDTO.setNumReservation(getNextNumeroReservation());
    ReservationEntity reservation = reservationMapper.toEntity(reservationDTO);
    reservation = reservationRepository.save(reservation);
    return reservationMapper.toDto(reservation);
  }

  @Override
  public ReservationDTO addPayedReservation(ReservationDTO reservationDTO) {
    reservationDTO.setUser(userUtils.getConnectedUser());
    reservationDTO.setNumReservation(getNextNumeroReservation());
    reservationDTO.setFacture(factureUtils.generateFacture(reservationDTO));
    ReservationEntity reservation = reservationMapper.toEntity(reservationDTO);
    reservation = reservationRepository.save(reservation);
    return reservationMapper.toDto(reservation);
  }

  @Override
  public ReservationDTO addFactureForExistReservation(String numReservation) {
    ReservationDTO reservationDTO = reservationMapper.toDto(
      reservationRepository.findByNumReservation(numReservation)
    );
    reservationDTO.setUser(userUtils.getConnectedUser());
    reservationDTO.setFacture(factureUtils.generateFacture(reservationDTO));
    return reservationMapper.toDto(
      reservationRepository.save(
        reservationMapper.toEntity(reservationDTO)
      )
    );
  }

  @Override
  public void cancelReservation(String numReservation) {
    reservationRepository.annulerReservation(numReservation);
  }

  @Override
  public String getNextNumeroReservation() {
    String pattern = LocalDate.now()
      .format(
        DateTimeFormatter.ofPattern("yyyyMMdd")
      );
    Optional<String> max = reservationRepository.getMaxNumeroReservation(pattern+"%");
    return max.map(s -> String.valueOf(Long.parseLong(s) + 1)).orElseGet(() -> pattern + "001");
  }
}
