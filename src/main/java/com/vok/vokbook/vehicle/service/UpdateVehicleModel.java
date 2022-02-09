package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.vehicle.controller.dto.ModelPartDTO;
import com.vok.vokbook.vehicle.controller.dto.VehicleModelDTO;
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
public class UpdateVehicleModel {

    private final VehicleModelRepository vehicleModelRepository;
    private final GetVehicleModels getVehicleModels;

    @Transactional
    public VehicleModel execute(Long vehicleModelId, VehicleModelDTO.UpdateRequest request) {
        VehicleModel vehicleModel = getVehicleModels.get(vehicleModelId); // todo: add check if model was not found
        VehicleModel model = updateVehicleModel(vehicleModel, request);
        return vehicleModelRepository.save(model);
    }

    private VehicleModel updateVehicleModel(VehicleModel vehicleModel, VehicleModelDTO.UpdateRequest request) {
        vehicleModel.setName(request.getName());
        vehicleModel.setDescription(request.getDescription());
        vehicleModel.setVehicleModelParts(createNewModelParts(request.getVehicleModelParts()));
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
