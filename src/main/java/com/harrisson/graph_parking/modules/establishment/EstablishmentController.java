package com.harrisson.graph_parking.modules.establishment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class EstablishmentController {

    @Autowired
    private EstablishmentService service;

    @MutationMapping("addEstablishment")
    public Establishment addEstablishment(@Argument EstablishmentInput establishmentInput) {
        return service.saveEstablishment(establishmentInput);
    }

    @QueryMapping("establishments")
    public Iterable<Establishment> establishments() {
        return service.getAll();
    }

    @QueryMapping("establishmentById")
    public Establishment establishmentById(@Argument UUID id) {
        return service.getById(id);
    }

    @MutationMapping("updateEstablishment")
    public Establishment updateEstablishment(@Argument UUID establishmentId, @Argument EstablishmentInput establishmentInput) {
        return service.updateEstablishment(establishmentId, establishmentInput);
    }

    @MutationMapping("deleteEstablishment")
    public void deleteEstablishment(@Argument UUID establishmentId) {
        service.deleteEstablishment(establishmentId);
    }
    @MutationMapping("changeStatusEstablishment")
    public void changeStatusEstablishment(@Argument UUID establishmentId) {
        service.changeStatusEstablishment(establishmentId);
    }
}
