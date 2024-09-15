package com.harrisson.graph_parking.modules.access_control;

import com.harrisson.graph_parking.modules.vehicle.VehicleType;
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

    @MutationMapping("createAccessControl")
    public AccessControl createAccessControl(@Argument UUID establishmentId) {
        return service.createAccessControl(establishmentId);
    }

    @MutationMapping("registerEntry")
    public AccessControl registerEntry(@Argument String plate, @Argument VehicleType type, @Argument UUID establishmentId) {
        return service.registerEntry(plate, type, establishmentId);
    }

    @MutationMapping("registerExit")
    public AccessControl registerExit(@Argument String plate) {
        return service.registerExit(plate);
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
