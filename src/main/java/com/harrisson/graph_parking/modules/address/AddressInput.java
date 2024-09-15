package com.harrisson.graph_parking.modules.address;

public record AddressInput(
        String street,
        String number,
        String neighborhood,
        String city,
        String uf,
        String cep,
        String complement
) {
}
