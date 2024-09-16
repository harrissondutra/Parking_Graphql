package com.harrisson.graph_parking.modules.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Vehicle addVehicle(VehicleInput vehicleInput) {
        var vehicle = Vehicle.builder()
                .brand(vehicleInput.brand())
                .model(vehicleInput.model())
                .color(vehicleInput.color())
                .plate(vehicleInput.plate())
                .type(vehicleInput.type())
                .build();
        return this.repository.save(vehicle);
    }

    public Iterable<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Vehicle updateVehicle(UUID vehicleId, VehicleInput vehicleInput) {
        var vehicle = repository.findById(vehicleId).orElse(null);
        if (vehicle == null) {
           throw new RuntimeException("Vehicle not found");
        }
        Vehicle.builder()
                .brand(vehicleInput.brand())
                .model(vehicleInput.model())
                .color(vehicleInput.color())
                .plate(vehicleInput.plate())
                .type(vehicleInput.type())
                .build();

        return repository.save(vehicle);
    }

    public void deleteVehicle(UUID vehicleId) {
        var vehicle = repository.findById(vehicleId).orElseThrow();
        vehicle.setActive(false);
    }

    public void inactiveVehicle(UUID vehicleId) {
        var vehicle = repository.findById(vehicleId).orElseThrow();
        var active = vehicle.getActive();
        vehicle.setActive(!active);
    }
}
