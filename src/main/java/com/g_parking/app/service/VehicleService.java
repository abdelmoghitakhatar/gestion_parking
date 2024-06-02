package com.g_parking.app.service;

import com.g_parking.app.dto.VehicleDTO;

import java.util.List;


public interface VehicleService {

    VehicleDTO addVehicle(VehicleDTO vehicleDTO);

    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);

    VehicleDTO getVehicleByMatricule(String matricule);

    List<VehicleDTO> getVehicles();

    void removeVehicle(String matricule);

}
