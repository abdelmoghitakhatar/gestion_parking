package com.g_parking.app.web.controller;

import com.g_parking.app.dto.VehicleDTO;
import com.g_parking.app.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicle")
    public VehicleDTO addVehicle(@RequestBody VehicleDTO vehicleDTO){
        if(vehicleDTO.getId() != null){
            throw new RuntimeException("Vehicle not accepted");
        }
        if(vehicleService.getVehicleByMatricule(vehicleDTO.getMatricule()) != null){
            throw new RuntimeException("Vehicle already exists");
        }
        return vehicleService.addVehicle(vehicleDTO);
    }

    @PutMapping("/vehicle/{matricule}")
    public VehicleDTO updateVehicle(@RequestBody VehicleDTO vehicleDTO, @PathVariable String matricule){
        if(!Objects.equals(vehicleDTO.getMatricule(), matricule) || vehicleDTO.getId() == null){
            throw new RuntimeException("Vehicle not accepted");
        }
        if(vehicleService.getVehicleByMatricule(vehicleDTO.getMatricule()) == null){
            throw new RuntimeException("Vehicle not found");
        }
        return vehicleService.updateVehicle(vehicleDTO);
    }

    @GetMapping("/vehicle/{matricule}")
    public VehicleDTO getVehicleByMatricule(@PathVariable String matricule){
        VehicleDTO vehicle = vehicleService.getVehicleByMatricule(matricule);
        if(vehicle == null){
            throw new RuntimeException("Vehicle not found");
        }
        return  vehicle;
    }

    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicles(){
        List<VehicleDTO> vehicle = vehicleService.getVehicles();
        if(vehicle == null){
            throw new RuntimeException("Vehicle not found");
        }
        return  vehicle;
    }

    @DeleteMapping("/vehicle/{matricule}")
    public void deleteVehicle(@PathVariable String matricule){
        vehicleService.removeVehicle(matricule);
    }

}
