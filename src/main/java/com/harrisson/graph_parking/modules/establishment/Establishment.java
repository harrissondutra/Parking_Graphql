package com.harrisson.graph_parking.modules.establishment;

import com.harrisson.graph_parking.core.EntityBase;
import com.harrisson.graph_parking.modules.address.Address;
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
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditTable(value = "establishment_audit", schema = "graphql_audit")
@Table(name = "establishment", schema = "graphql")
@Entity
public class Establishment extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String cnpj;
    @Embedded
    private Address address;
    private String phone;
    private Integer qtMotorcycles;
    private Integer qtCars;



}
