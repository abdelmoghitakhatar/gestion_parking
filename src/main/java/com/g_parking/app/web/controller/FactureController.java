package com.g_parking.app.web.controller;

import com.g_parking.app.dto.FactureDTO;
import com.g_parking.app.service.FactureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facture")
public class FactureController {

  private final FactureService factureService;

  public FactureController(FactureService factureService) {
    this.factureService = factureService;
  }

}
