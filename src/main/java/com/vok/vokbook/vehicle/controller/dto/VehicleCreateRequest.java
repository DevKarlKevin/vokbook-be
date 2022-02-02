package com.vok.vokbook.vehicle.controller.dto;

import com.vok.vokbook.vehicle.enumerator.Fleet;
import com.vok.vokbook.vehicle.enumerator.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VehicleCreateRequest {

    @NotNull
    @NotEmpty
    private String vokId;

    @NotBlank
    private String coModuleId;

    @NotBlank
    private String identifier;

    @NotBlank
    private Fleet fleet;

    @NotBlank
    private String model;

    @NotBlank
    private Status status;

    @NotBlank
    private String repo;

    @NotBlank
    private String ecuBranch;

    @NotBlank
    private String ecuCommit;

    @NotBlank
    private String csCommit;

    @NotNull
    @NotEmpty
    private String rfid;

}
