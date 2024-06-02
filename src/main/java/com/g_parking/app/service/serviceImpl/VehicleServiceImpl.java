package com.g_parking.app.service.serviceImpl;

import com.g_parking.app.domain.VehicleEntity;
import com.g_parking.app.dto.UserDTO;
import com.g_parking.app.dto.VehicleDTO;
import com.g_parking.app.repository.UserRepository;
import com.g_parking.app.repository.VehicleRepository;
import com.g_parking.app.service.VehicleService;
import com.g_parking.app.service.mapper.VehicleMapper;
import com.g_parking.app.web.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

  private final UserUtils userUtils;
  private VehicleRepository vehicleRepository;
  private VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, UserUtils userUtils) {
      this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
      this.userUtils = userUtils;
    }

    @Override
    public VehicleDTO addVehicle(VehicleDTO vehicleDTO) {

      UserDTO userDTO = userUtils.getConnectedUser();

      vehicleDTO.setUser(userDTO);

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
      return vehicle.map(vehicleEntity -> vehicleMapper.toDto(vehicleEntity)).orElse(null);

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
