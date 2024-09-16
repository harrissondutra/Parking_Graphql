package com.harrisson.graph_parking.modules.vehicle;

import com.harrisson.graph_parking.core.EntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "vehicles_audit", schema = "graphql_audit")
@Table(name = "vehicles", schema = "graphql")
@Entity
public class Vehicle extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String brand;
    private String model;
    private String color;
    private String plate;
    @Enumerated(EnumType.STRING)
    private VehicleType type;
    private Boolean active = true;

}
