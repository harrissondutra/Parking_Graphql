package com.harrisson.graph_parking.modules.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    Vehicle findByPlate(String plate);
}
