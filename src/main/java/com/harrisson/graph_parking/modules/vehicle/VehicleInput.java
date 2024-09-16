package com.harrisson.graph_parking.modules.vehicle;

public record VehicleInput(
        String brand,
        String model,
        String color,
        String plate,
        VehicleType type,
        Boolean active
) {

}
