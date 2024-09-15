package com.harrisson.graph_parking.modules.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {

    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String uf;
    private String cep;
    private String complement;

    public Address(AddressInput address) {
        this.street = address.street();
        this.number = address.number();
        this.neighborhood = address.neighborhood();
        this.city = address.city();
        this.uf = address.uf();
        this.cep = address.cep();
        this.complement = address.complement();
    }
}
