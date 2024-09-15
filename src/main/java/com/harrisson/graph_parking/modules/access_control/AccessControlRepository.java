package com.harrisson.graph_parking.modules.access_control;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessControlRepository extends JpaRepository<AccessControl, Long> {
    AccessControl findByVehiclePlate(String vehiclePlate);
}
