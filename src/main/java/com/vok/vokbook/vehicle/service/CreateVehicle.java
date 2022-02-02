package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.vehicle.controller.dto.VehicleCreateRequest;
import com.vok.vokbook.vehicle.domain.Vehicle;
import com.vok.vokbook.vehicle.enumerator.Status;
import com.vok.vokbook.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateVehicle {

    private final VehicleRepository vehicleRepository;

    public Vehicle execute(VehicleCreateRequest request) {
        final Vehicle vehicle = createNewVehicle(request);
        return vehicleRepository.save(vehicle);
    }

    private Vehicle createNewVehicle(VehicleCreateRequest request) {
        return new Vehicle()
                .setCoModuleId(request.getCoModuleId())
                .setCsCommit(request.getCsCommit())
                .setEcuBranch(request.getEcuBranch())
                .setEcuCommit(request.getEcuCommit())
                .setFleet(request.getFleet())
                .setIdentifier(request.getIdentifier())
                .setRepo(request.getRepo())
                .setVokId(request.getVokId())
                .setRfid(request.getRfid())
                .setStatus(Status.ACTIVE);
    }
}
