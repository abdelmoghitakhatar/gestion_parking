package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.domain.ReservationEntity;
import com.g_parking.app.dto.FactureDTO;
import com.g_parking.app.dto.ReservationDTO;
import com.g_parking.app.repository.FactureRepository;
import com.g_parking.app.repository.ReservationRepository;
import com.g_parking.app.service.FactureService;
import com.g_parking.app.service.mapper.FactureMapper;
import com.g_parking.app.service.mapper.ReservationMapper;
import com.g_parking.app.web.utils.FactureUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FactureServiceImpl implements FactureService {

  private final FactureUtils factureUtils;
  private final ReservationRepository reservationRepository;
  private final ReservationMapper reservationMapper;
  private final FactureRepository factureRepository;
  private final FactureMapper factureMapper;

  public FactureServiceImpl(FactureUtils factureUtils, ReservationRepository reservationRepository, ReservationMapper reservationMapper, FactureRepository factureRepository, FactureMapper factureMapper) {
    this.factureUtils = factureUtils;
    this.reservationRepository = reservationRepository;
    this.reservationMapper = reservationMapper;
    this.factureRepository = factureRepository;
    this.factureMapper = factureMapper;
  }
}
