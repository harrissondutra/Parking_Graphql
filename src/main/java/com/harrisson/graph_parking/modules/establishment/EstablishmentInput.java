package com.harrisson.graph_parking.modules.establishment;

import com.harrisson.graph_parking.modules.address.Address;
import com.harrisson.graph_parking.modules.address.AddressInput;

public record EstablishmentInput(
        String name,
        String cnpj,
        AddressInput address,
        String phone,
        Integer qtMotorcycles,
        Integer qtCars,
        Boolean active

) {
}
