package com.vok.vokbook.vehicle.controller.dto;

import com.vok.vokbook.vehicle.enumerator.PartLocation;
import lombok.Data;

@Data
public class VehiclePartDTO {
    private String partId;
    private String rev;
    private String description;
    private PartLocation partLocation;
}
