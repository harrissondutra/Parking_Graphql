package com.harrisson.graph_parking.modules.access_control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class AccessControlController {

    @Autowired
    private AccessControlService service;

    @MutationMapping("registerEntry")
    public AccessControl registerEntry(@Argument UUID vehicleId, @Argument UUID establishmentId) {
        return service.registerEntry(vehicleId, establishmentId);
    }

    @MutationMapping("registerExit")
    public AccessControl registerExit(@Argument UUID vehicleId, @Argument UUID establishmentId) {
        return service.registerExit(vehicleId, establishmentId);
    }

    @QueryMapping("accessControls")
    public Iterable<AccessControl> accessControls() {
        return service.findAll();
    }

    @QueryMapping("findByVehiclePlate")
    public AccessControl findAccessControlByVehiclePlate(@Argument String vehiclePlate) {
        return service.findAccessControlByVehiclePlate(vehiclePlate);
    }
}
