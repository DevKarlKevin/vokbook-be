package com.vok.vokbook.vehicle.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponse {
    private Long vehicleId;
    private String comoduleId;
    private String identifier;
    private String fleet;
    private String model;
    private Integer mileage;
    private String status;
    private String repo;
    private String ecuBranch;
    private String ecuCommit;
    private String csCommit;

}
