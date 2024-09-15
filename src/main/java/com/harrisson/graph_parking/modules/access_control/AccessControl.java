package com.harrisson.graph_parking.modules.access_control;

import com.harrisson.graph_parking.core.EntityBase;
import com.harrisson.graph_parking.modules.establishment.Establishment;
import com.harrisson.graph_parking.modules.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "access_control_audit", schema = "graphql_audit")
@Table(name = "access-control", schema = "graphql")
@Entity
public class AccessControl extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "establishment_id", nullable = false)
    private Establishment establishment;

    @Column(name = "entry_time")
    private LocalDateTime entryTime;

    @Column(name = "exit_time")
    private LocalDateTime exitTime ;

    @Column(name = "active")
    private Boolean active;

}
