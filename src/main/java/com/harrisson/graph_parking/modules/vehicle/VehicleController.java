package com.harrisson.graph_parking.modules.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService service;

    @MutationMapping("addVehicle")
    public Vehicle addVehicle(@Argument VehicleInput vehicleInput) {
        return this.service.addVehicle(vehicleInput);
    }

    @QueryMapping("vehicles")
    public Iterable<Vehicle> vehicles() {
        return service.findAll();
    }

    @QueryMapping("vehicleById")
    public Vehicle vehicleById(@Argument UUID id) {
        return service.findById(id);
    }

}
