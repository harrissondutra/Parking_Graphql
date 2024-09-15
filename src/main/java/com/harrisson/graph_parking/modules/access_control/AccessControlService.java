package com.harrisson.graph_parking.modules.access_control;

import com.harrisson.graph_parking.modules.establishment.EstablishmentRepository;
import com.harrisson.graph_parking.modules.vehicle.Vehicle;
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

    public AccessControl createAccessControl(UUID establishmentId) {
        var establishment = establishmentRepository.findById(establishmentId).orElseThrow(() -> new RuntimeException("Establishment not found"));
        var access = AccessControl.builder()
                .establishment(establishment)
                .build();
        return repository.save(access);
    }

    public AccessControl registerEntry(String plate, UUID establishmentId) {
        var vehicle = vehicleRepository.findByPlate(plate);
        if (vehicle == null) {
            vehicle = vehicleRepository.save(Vehicle.builder().plate(plate).build());
        }
        var establishment = establishmentRepository.findById(establishmentId).orElseThrow(() -> new RuntimeException("Establishment not found"));
        return AccessControl.builder()
                .vehicle(vehicle)
                .establishment(establishment)
                .entryTime(LocalDateTime.now())
                .build();
    }

    public AccessControl registerExit(String plate) {
        var access = this.findAccessControlByVehiclePlate(plate);
        access.setExitTime(LocalDateTime.now());
        return repository.save(access);
    }

    public Iterable<AccessControl> findAll() {
        return repository.findAll();
    }

    public AccessControl findAccessControlByVehiclePlate(String vehiclePlate) {
        return repository.findByVehiclePlate(vehiclePlate);
    }


}