package com.harrisson.graph_parking.modules.access_control;

import com.harrisson.graph_parking.modules.vehicle.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

public interface AccessControlRepository extends JpaRepository<AccessControl, Long> {

    @Query("SELECT COUNT(a) FROM AccessControl a WHERE a.establishment.id = :establishmentId AND a.vehicle.type = :vehicleType")
    Integer countByEstablishmentIdAndVehicleType(UUID establishmentId, VehicleType vehicleType);

    AccessControl findByVehicle_PlateAndActiveIsTrue(String plate);

    @Transactional
    @Modifying
    @Query("update AccessControl a set a.exitTime = ?1 where a.exitTime in ?2")
    int updateAccess(LocalDateTime exitTime, Collection<LocalDateTime> exitTimes);
}
