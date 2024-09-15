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
}
