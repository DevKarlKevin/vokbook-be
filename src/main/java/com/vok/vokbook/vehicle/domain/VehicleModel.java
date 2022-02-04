package com.vok.vokbook.vehicle.domain;

import com.vok.vokbook.common.AuditableEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class VehicleModel extends AuditableEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "vehicleModel", orphanRemoval = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<VehicleModelPart> vehicleModelParts;
}
