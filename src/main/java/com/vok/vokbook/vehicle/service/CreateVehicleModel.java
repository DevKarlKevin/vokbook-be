package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.vehicle.controller.dto.VehicleModelDTO;
import com.vok.vokbook.vehicle.controller.dto.ModelPartDTO;
import com.vok.vokbook.vehicle.domain.VehicleModel;
import com.vok.vokbook.vehicle.domain.VehicleModelPart;
import com.vok.vokbook.vehicle.repository.VehicleModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CreateVehicleModel {

    private final VehicleModelRepository vehicleModelRepository;

    @Transactional
    public VehicleModel execute(VehicleModelDTO.CreateRequest request) {
        final com.vok.vokbook.vehicle.domain.VehicleModel model = createNewModel(request);
        return vehicleModelRepository.save(model);
    }

    private VehicleModel createNewModel(VehicleModelDTO.CreateRequest request) {
        final VehicleModel vehicleModel = new VehicleModel()
                .setName(request.getName())
                .setDescription(request.getDescription());

        List<VehicleModelPart> vehicleModelParts = createNewModelParts(request.getVehicleModelParts());
        vehicleModel.setVehicleModelParts(vehicleModelParts);
        return vehicleModel;
    }

    private List<VehicleModelPart> createNewModelParts(List<ModelPartDTO> modelPartDTOS) {
        return modelPartDTOS.stream().map(this::createNewModelPart).collect(Collectors.toList());
    }

    private VehicleModelPart createNewModelPart(ModelPartDTO modelPartDTO) {
        return new VehicleModelPart()
                .setPartId(modelPartDTO.getPartId())
                .setRev(modelPartDTO.getRev())
                .setDescription(modelPartDTO.getDescription())
                .setPartLocation(modelPartDTO.getPartLocation());
    }
}
