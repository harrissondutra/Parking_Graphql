package com.harrisson.graph_parking.modules.access_control;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AccessControlRepository extends JpaRepository<AccessControl, Long> {
    AccessControl findByVehiclePlate(String vehiclePlate);
    @Query("SELECT COUNT(a) FROM AccessControl a WHERE a.establishment.id = :establishmentId AND a.vehicle.type = :vehicleType")
    int countByEstablishmentIdAndVehicleType(UUID establishmentId, String vehicleType);
}
