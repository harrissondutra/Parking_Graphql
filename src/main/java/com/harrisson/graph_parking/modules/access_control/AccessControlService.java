package com.harrisson.graph_parking.modules.access_control;

import com.harrisson.graph_parking.modules.establishment.EstablishmentRepository;
import com.harrisson.graph_parking.modules.vehicle.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccessControlService {

    @Autowired
    private AccessControlRepository repository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private EstablishmentRepository establishmentRepository;

    public AccessControl registerEntry(UUID vehicleId, UUID establishmentId) {
        var vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        var establishment = establishmentRepository.findById(establishmentId).orElseThrow(() -> new RuntimeException("Establishment not found"));
        return AccessControl.builder()
                .vehicle(vehicle)
                .establishment(establishment).build();
    }

    public AccessControl registerExit(UUID vehicleId, UUID establishmentId) {
        var vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        var establishment = establishmentRepository.findById(establishmentId)
                .orElseThrow(() -> new RuntimeException("Establishment not found"));
        return AccessControl.builder()
                .vehicle(vehicle)
                .establishment(establishment)
                .exitTime(LocalDateTime.now())
                .build();
    }

    public Iterable<AccessControl> findAll() {
        return repository.findAll();
    }

    public AccessControl findAccessControlByVehiclePlate(String vehiclePlate) {
        return repository.findByVehiclePlate(vehiclePlate);
    }
}