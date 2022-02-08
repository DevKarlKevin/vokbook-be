package com.vok.vokbook.vehicle.domain;

import com.vok.vokbook.common.AuditableEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class VehicleModel extends AuditableEntity {

    private String name;
    private String description;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name ="vehicle_model_id")
    private List<VehicleModelPart> vehicleModelParts = new ArrayList<>();
}
