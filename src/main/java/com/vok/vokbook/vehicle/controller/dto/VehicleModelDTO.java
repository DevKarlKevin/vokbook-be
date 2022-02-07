package com.vok.vokbook.vehicle.controller.dto;

import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class VehicleModelDTO {

    @Value
    public static class CreateRequest {

        @NotBlank
        String name;
        String description;

        @Valid
        List<ModelPartDTO> vehicleModelParts;
    }

    @Value
    public static class Response {
        Long id;
        String name;
        String description;
        List<ModelPartDTO> vehicleModelParts;
    }

}
