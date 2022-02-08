package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.TestUtils;
import com.vok.vokbook.vehicle.controller.dto.VehicleDTO;
import com.vok.vokbook.vehicle.domain.Vehicle;
import com.vok.vokbook.vehicle.domain.VehicleModel;
import com.vok.vokbook.vehicle.enumerator.Fleet;
import com.vok.vokbook.vehicle.enumerator.Status;
import com.vok.vokbook.vehicle.repository.VehicleModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CreateVehicleIT {

    @Autowired
    private CreateVehicle createVehicle;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Test
    public void test_createVehicle_success() {
        VehicleModel vehicleModel = TestUtils.createVehicleModel();
        vehicleModel = vehicleModelRepository.save(vehicleModel);

        final VehicleDTO.CreateRequest request = new VehicleDTO.CreateRequest(
                "vokId",
                "coModuleId",
                "Identifier",
                Fleet.VOK_BIKES_TALLINN,
                vehicleModel.getId(),
                Status.ACTIVE,
                "repo",
                "ecuBranch",
                "ecuCommit",
                "csCommit",
                "rfid"
        );

        final Vehicle vehicle = createVehicle.execute(request);

        assertThat(vehicle.getCoModuleId()).isEqualTo("coModuleId");
        assertThat(vehicle.getCsCommit()).isEqualTo("csCommit");
        assertThat(vehicle.getEcuBranch()).isEqualTo("ecuBranch");
        assertThat(vehicle.getEcuCommit()).isEqualTo("ecuCommit");
        assertThat(vehicle.getIdentifier()).isEqualTo("Identifier");
        assertThat(vehicle.getRepo()).isEqualTo("repo");
        assertThat(vehicle.getFleet()).isEqualTo(Fleet.VOK_BIKES_TALLINN);
        assertThat(vehicle.getRfid()).isEqualTo("rfid");
        assertThat(vehicle.getStatus()).isEqualTo(Status.ACTIVE);
        assertThat(vehicle.getVokId()).isEqualTo("vokId");

        assertThat(vehicle.getVehicleParts()).hasSize(1);
    }
}
