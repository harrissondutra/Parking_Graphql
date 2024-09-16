package com.harrisson.graph_parking.modules.establishment;

import com.harrisson.graph_parking.modules.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository repository;

    public Establishment saveEstablishment(EstablishmentInput establishmentInput) {
        var establishment = Establishment.builder()
                .name(establishmentInput.name())
                .cnpj(establishmentInput.cnpj())
                .address(new Address(establishmentInput.address()))
                .phone(establishmentInput.phone())
                .qtMotorcycles(establishmentInput.qtMotorcycles())
                .qtCars(establishmentInput.qtCars())
                .build();
        return repository.save(establishment);
    }

    public Iterable<Establishment> getAll() {
        return repository.findAll();
    }

    public Establishment getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Establishment updateEstablishment(UUID establishmentId, EstablishmentInput establishmentInput) {
        var establishment = repository.findById(establishmentId).orElse(null);
        if (establishment == null) {
            throw new IllegalStateException("Establishment not found");
        }
        Establishment.builder()
                .name(establishmentInput.name())
                .cnpj(establishmentInput.cnpj())
                .address(new Address(establishmentInput.address()))
                .phone(establishmentInput.phone())
                .qtMotorcycles(establishmentInput.qtMotorcycles())
                .qtCars(establishmentInput.qtCars())
                .build();

        return repository.save(establishment);
    }

    public void deleteEstablishment(UUID establishmentId) {
        var establishment = repository.findById(establishmentId).orElse(null);
        assert establishment != null;
        establishment.setActive(false);
    }

    public void changeStatusEstablishment(UUID establishmentId) {
        var establishment = repository.findById(establishmentId).orElse(null);
        assert establishment != null;
         var active = establishment.getActive();
        establishment.setActive(!active);
    }
}
