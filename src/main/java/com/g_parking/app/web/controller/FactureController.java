package com.g_parking.app.web.controller;

import com.g_parking.app.service.FactureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facture")
public class FactureController {

  private FactureService factureService;

  public FactureController(FactureService factureService) {
    this.factureService = factureService;
  }
}
