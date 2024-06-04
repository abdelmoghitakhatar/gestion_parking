package com.g_parking.app.web.controller;

import com.g_parking.app.service.FactureService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facture")
public class FactureController {

  private final FactureService factureService;

  public FactureController(FactureService factureService) {
    this.factureService = factureService;
  }

}
