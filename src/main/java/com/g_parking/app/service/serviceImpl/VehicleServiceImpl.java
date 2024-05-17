package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.domain.VehicleEntity;
import com.g_parking.app.dto.VehicleDTO;
import com.g_parking.app.repository.VehicleRepository;
import com.g_parking.app.service.VehicleService;
import com.g_parking.app.service.mapper.VehicleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    private VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {

        VehicleEntity vehicle = vehicleMapper.toEntity(vehicleDTO);
        vehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toDto(vehicle);
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {

        VehicleEntity vehicle = vehicleMapper.toEntity(vehicleDTO);
        vehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toDto(vehicle);
    }

    @Override
    public VehicleDTO getVehicleByMatricule(String matricule) {

        Optional<VehicleEntity> vehicle = vehicleRepository.findVehicleEntityByMatricule(matricule);
        if(vehicle.isPresent()){
            return vehicleMapper.toDto(vehicle.get());
        }

        return null;
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        return vehicleMapper.toDto(vehicleRepository.findAll());
    }

    @Override
    public void removeVehicle(String matricule) {
        vehicleRepository.deleteByMatricule(matricule);
    }
}
