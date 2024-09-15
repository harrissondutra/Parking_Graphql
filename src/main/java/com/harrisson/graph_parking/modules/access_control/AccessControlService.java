package com.harrisson.graph_parking.modules.access_control;

import com.harrisson.graph_parking.modules.establishment.EstablishmentRepository;
import com.harrisson.graph_parking.modules.vehicle.Vehicle;
import com.harrisson.graph_parking.modules.vehicle.VehicleRepository;
import com.harrisson.graph_parking.modules.vehicle.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public AccessControl registerEntry(String plate, VehicleType type, UUID establishmentId) {
        var vehicle = vehicleRepository.findByPlate(plate);
        if (vehicle == null) {
            vehicle = vehicleRepository.save(Vehicle.builder().plate(plate).type(type).build());
        }
        var establishment = establishmentRepository.findById(establishmentId).orElseThrow(() -> new RuntimeException("Establishment not found"));

        if (vehicle.getType().equals(VehicleType.CAR)) {
            Integer currentCarCount = repository.countByEstablishmentIdAndVehicleType(establishmentId, VehicleType.CAR);
            if (currentCarCount >= establishment.getQtCars()) {
                throw new RuntimeException("Limite de vagas para carros atingido");
            }
        } else if (vehicle.getType().equals(VehicleType.MOTORCYCLE)) {
            Integer currentMotorcycleCount = repository.countByEstablishmentIdAndVehicleType(establishmentId, VehicleType.MOTORCYCLE);
            if (currentMotorcycleCount >= establishment.getQtMotorcycles()) {
                throw new RuntimeException("Limite de vagas para motocicletas atingido");
            }
        }

        var accessControl = AccessControl.builder()
                .vehicle(vehicle)
                .establishment(establishment)
                .entryTime(LocalDateTime.now()) // Setando a data de entrada
                .active(true)
                .build();
        return repository.save(accessControl);
    }

    public AccessControl registerExit(String plate) {
        var access = repository.findByVehicle_PlateAndActiveIsTrue(plate);

        if (access == null) {
            throw new RuntimeException("Acesso não encontrado");
        }
        access.setExitTime(LocalDateTime.now());
        access.setActive(false);

        return repository.save(access);
    }

    public Iterable<AccessControl> findAll() {
        return repository.findAll();
    }

    public AccessControl findAccessControlByVehiclePlate(String vehiclePlate) {
        return repository.findByVehicle_PlateAndActiveIsTrue(vehiclePlate);
    }


}