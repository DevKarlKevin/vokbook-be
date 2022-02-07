package com.vok.vokbook.vehicle.domain;

import com.vok.vokbook.common.AuditableEntity;
import com.vok.vokbook.vehicle.enumerator.PartLocation;
import com.vok.vokbook.vehicle.enumerator.VehiclePartCondition;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
public class VehiclePart extends AuditableEntity {

    private String partId;

    private String rev;

    private String description;

    @Enumerated(EnumType.STRING)
    private VehiclePartCondition condition;

    @Enumerated(EnumType.STRING)
    private PartLocation partLocation;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
