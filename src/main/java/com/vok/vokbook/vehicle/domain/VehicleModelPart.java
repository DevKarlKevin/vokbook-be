package com.vok.vokbook.vehicle.domain;

import com.vok.vokbook.common.AuditableEntity;
import com.vok.vokbook.vehicle.enumerator.PartLocation;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

// todo: move it to model package
@Entity
@Data
@Accessors(chain = true)
public class VehicleModelPart extends AuditableEntity {

    private String partId;

    private String rev;

    private String description;

    @Enumerated(EnumType.STRING)
    private PartLocation partLocation;

    private Long modelId;

    private Long vehicleModelId;
}
