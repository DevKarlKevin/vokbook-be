package com.vok.vokbook.vehicle.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class VehicleRequest {
    @NotBlank
    private String comoduleId;

    @NotBlank
    private String identifier;

    @NotBlank
    private String fleet;

    @NotBlank
    private String model;

    @NotBlank
    private Integer mileage;

    @NotBlank
    private String status;

    @NotBlank
    private String repo;

    @NotBlank
    private String ecuBranch;

    @NotBlank
    private String ecuCommit;

    @NotBlank
    private String csCommit;

}
