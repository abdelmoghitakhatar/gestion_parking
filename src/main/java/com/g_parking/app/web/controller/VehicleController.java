package com.g_parking.app.web.controller;

import com.g_parking.app.domain.enumeration.ErrorMessage;
import com.g_parking.app.dto.VehicleDTO;
import com.g_parking.app.service.VehicleService;
import com.g_parking.app.web.exceptions.VehicleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("")
    public ResponseEntity<VehicleDTO> addVehicle(@RequestBody VehicleDTO vehicleDTO) throws VehicleException {
        if(vehicleDTO.getId() != null){
            throw new VehicleException(ErrorMessage.VEHICLE_NOT_ACCEPTED.getMessage());
        }
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{matricule}")
    public ResponseEntity<VehicleDTO> updateVehicle(@RequestBody VehicleDTO vehicleDTO, @PathVariable String matricule) throws VehicleException {
        if(!Objects.equals(vehicleDTO.getMatricule(), matricule) || vehicleDTO.getId() == null){
            throw new VehicleException(ErrorMessage.UPDATE_NOT_ACCEPTED.getMessage());
        }
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{matricule}")
    public ResponseEntity<VehicleDTO> getVehicleByMatricule(@PathVariable String matricule) throws VehicleException {
        VehicleDTO vehicle = vehicleService.getVehicleByMatricule(matricule);
        if(vehicle == null){
            throw new VehicleException(ErrorMessage.VEHICLE_NOT_FOUND.getMessage());
        }
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() throws VehicleException {
        List<VehicleDTO> vehicles = vehicleService.getVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @DeleteMapping("/{matricule}")
    public void deleteVehicle(@PathVariable String matricule){
        vehicleService.removeVehicle(matricule);
    }

}
