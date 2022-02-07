package com.vok.vokbook.vehicle.controller.dto;

import com.vok.vokbook.vehicle.enumerator.Fleet;
import com.vok.vokbook.vehicle.enumerator.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VehicleDTO {

    @Value
    public static class CreateRequest {
        @NotNull
        @NotEmpty
        String vokId;

        @NotBlank
        String coModuleId;

        @NotBlank
        String identifier;

        @NotBlank
        Fleet fleet;

        @NotBlank
        String model;

        @NotBlank
        Status status;

        @NotBlank
        String repo;

        @NotBlank
        String ecuBranch;

        @NotBlank
        String ecuCommit;

        @NotBlank
        String csCommit;

        @NotNull
        @NotEmpty
        String rfid;
    }

    @Value
    public static class Response {
        Long id;
        String coModuleId;
        String vokId;
        String identifier;
        String fleet;
        String model;
        Integer mileage;
        String status;
        String repo;
        String ecuBranch;
        String ecuCommit;
        String csCommit;
        String rfid;
    }

}
