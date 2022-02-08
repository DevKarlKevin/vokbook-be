package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.vehicle.controller.dto.VehicleDTO;
import com.vok.vokbook.vehicle.domain.Vehicle;
import com.vok.vokbook.vehicle.domain.VehicleModel;
import com.vok.vokbook.vehicle.domain.VehicleModelPart;
import com.vok.vokbook.vehicle.domain.VehiclePart;
import com.vok.vokbook.vehicle.enumerator.Status;
import com.vok.vokbook.vehicle.enumerator.VehiclePartCondition;
import com.vok.vokbook.vehicle.repository.VehicleModelRepository;
import com.vok.vokbook.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CreateVehicle {

    private final VehicleRepository vehicleRepository;
    private final VehicleModelRepository vehicleModelRepository;

    @Transactional
    public Vehicle execute(VehicleDTO.CreateRequest request) {
        final Vehicle vehicle = createNewVehicle(request);
        return vehicleRepository.save(vehicle);
    }

    private Vehicle createNewVehicle(VehicleDTO.CreateRequest request) {
        VehicleModel vehicleModel = vehicleModelRepository.getById(request.getModel());

        final Vehicle vehicle = new Vehicle()
                .setCoModuleId(request.getCoModuleId())
                .setCsCommit(request.getCsCommit())
                .setEcuBranch(request.getEcuBranch())
                .setEcuCommit(request.getEcuCommit())
                .setFleet(request.getFleet())
                .setIdentifier(request.getIdentifier())
                .setVehicleModel(vehicleModel)
                .setRepo(request.getRepo())
                .setVokId(request.getVokId())
                .setRfid(request.getRfid())
                .setStatus(Status.ACTIVE);

        List<VehiclePart> vehicleParts = createNewParts(vehicleModel);
        vehicle.setVehicleParts(vehicleParts);

        return vehicle;
    }

    private List<VehiclePart> createNewParts(VehicleModel vehicleModel) {
        return vehicleModel.getVehicleModelParts().stream().map(this::createNewPart).collect(Collectors.toList());
    }

    private VehiclePart createNewPart(VehicleModelPart vehicleModelPart) {
        return new VehiclePart()
                .setPartId(vehicleModelPart.getPartId())
                .setRev(vehicleModelPart.getRev())
                .setDescription(vehicleModelPart.getDescription())
                .setPartLocation(vehicleModelPart.getPartLocation())
                .setCondition(VehiclePartCondition.OK);
    }
}
