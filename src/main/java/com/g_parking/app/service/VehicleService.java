package com.g_parking.app.service;

import com.g_parking.app.dto.VehicleDTO;

import java.util.List;


public interface VehicleService {

    public VehicleDTO addVehicle(VehicleDTO vehicleDTO);

    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO);

    public VehicleDTO getVehicleByMatricule(String matricule);

    public List<VehicleDTO> getVehicles();

    public void removeVehicle(String matricule);
    
}
