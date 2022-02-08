package com.vok.vokbook;

import com.vok.vokbook.vehicle.controller.dto.ModelPartDTO;
import com.vok.vokbook.vehicle.domain.VehicleModel;
import com.vok.vokbook.vehicle.domain.VehicleModelPart;
import com.vok.vokbook.vehicle.enumerator.PartLocation;

import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static ModelPartDTO createModelPartDTO(PartLocation partLocation) {
        final ModelPartDTO modelPart = new ModelPartDTO();
        modelPart.setPartId("test-id");
        modelPart.setRev("rev");
        modelPart.setPartLocation(partLocation);

        return modelPart;
    }

    public static VehicleModel createVehicleModel() {
        final VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setDescription("test");
        vehicleModel.setName("model name");

        List<VehicleModelPart> vehicleModelParts = new ArrayList<>();
        vehicleModelParts.add(createVehicleModelPart());
        vehicleModel.setVehicleModelParts(vehicleModelParts);
        return vehicleModel;
    }

    public static VehicleModelPart createVehicleModelPart() {
        final VehicleModelPart vehicleModelPart = new VehicleModelPart();
        vehicleModelPart.setPartId("test-id");
        vehicleModelPart.setRev("rev");
        vehicleModelPart.setDescription("desc");
        vehicleModelPart.setPartLocation(PartLocation.FRAME);

        return vehicleModelPart;
    }
}
