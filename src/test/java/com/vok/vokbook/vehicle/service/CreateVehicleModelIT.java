package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.TestUtils;
import com.vok.vokbook.vehicle.controller.dto.ModelPartDTO;
import com.vok.vokbook.vehicle.controller.dto.VehicleModelDTO;
import com.vok.vokbook.vehicle.domain.VehicleModel;
import com.vok.vokbook.vehicle.enumerator.PartLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CreateVehicleModelIT {

    @Autowired
    private CreateVehicleModel createVehicleModel;

    @Test
    public void test_createVehicleModel_success() {
        final List<ModelPartDTO> modelParts = new ArrayList<>();
        modelParts.add(TestUtils.createModelPartDTO(PartLocation.FRONT_LEFT));
        modelParts.add(TestUtils.createModelPartDTO(PartLocation.FRAME));

        final VehicleModelDTO.CreateRequest request = new VehicleModelDTO.CreateRequest(
                "test",
                "desc",
                modelParts
        );

        final VehicleModel vehicleModel = createVehicleModel.execute(request);

        assertThat(vehicleModel.getName()).isEqualTo("test");
        assertThat(vehicleModel.getDescription()).isEqualTo("desc");
        assertThat(vehicleModel.getVehicleModelParts()).hasSize(2)
                .anySatisfy(m -> {
                    assertThat(m.getPartLocation()).isEqualTo(PartLocation.FRONT_LEFT);
                });
    }
}
