package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.vehicle.controller.dto.VehicleCreateRequest;
import com.vok.vokbook.vehicle.domain.Vehicle;
import com.vok.vokbook.vehicle.enumerator.Fleet;
import com.vok.vokbook.vehicle.enumerator.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CreateVehicleIT {

    @Autowired
    private CreateVehicle createVehicle;

    @Test
    public void test_createVehicle_success() {
        final VehicleCreateRequest request = new VehicleCreateRequest();
        request.setCoModuleId("coModuleId");
        request.setCsCommit("csCommit");
        request.setEcuBranch("ecuBranch");
        request.setFleet(Fleet.VOK_BIKES_TALLINN);
        request.setIdentifier("Identifier");
        request.setRepo("repo");
        request.setEcuCommit("ecuCommit");
        request.setRfid("rfid");
        request.setStatus(Status.ACTIVE);
        request.setVokId("vokId");

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
    }
}
