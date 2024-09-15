package com.harrisson.graph_parking.modules.establishment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstablishmentRepository extends JpaRepository<Establishment, UUID> {
    Establishment getEstablishmentById(UUID establishmentId);
}
