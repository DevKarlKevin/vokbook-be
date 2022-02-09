package com.vok.vokbook.vehicle.domain;

import com.vok.vokbook.common.AuditableEntity;
import com.vok.vokbook.vehicle.enumerator.Fleet;
import com.vok.vokbook.vehicle.enumerator.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Vehicle extends AuditableEntity {

    private String vokId;

    private String identifier;

    @Enumerated(EnumType.STRING)
    private Fleet fleet;

    private BigDecimal mileage;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String coModuleId;

    private String repo;

    private String ecuBranch;

    private String ecuCommit;

    private String csCommit;

    private String rfid;

    @ManyToOne(fetch = FetchType.LAZY)
    private VehicleModel vehicleModel;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="vehicle_id")
    private List<VehiclePart> vehicleParts = new ArrayList<>();

    public void setVehicleParts(List<VehiclePart> vehicleParts) {
        this.vehicleParts.clear();
        this.vehicleParts.addAll(vehicleParts);
    }
}
