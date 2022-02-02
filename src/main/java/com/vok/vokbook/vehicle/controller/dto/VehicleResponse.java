package com.vok.vokbook.vehicle.controller.dto;

import lombok.Data;

@Data
public class VehicleResponse {
    private Long id;
    private String coModuleId;
    private String identifier;
    private String fleet;
    private String model;
    private Integer mileage;
    private String status;
    private String repo;
    private String ecuBranch;
    private String ecuCommit;
    private String csCommit;
    private String rfid;
}
