package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.vehicle.domain.VehicleModel;
import com.vok.vokbook.vehicle.repository.VehicleModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetVehicleModels {

    private final VehicleModelRepository vehicleModelRepository;

    public List<VehicleModel> getAll() {
        return vehicleModelRepository.findAll();
    }

    public VehicleModel get(Long vehicleModelId) {
        return vehicleModelRepository.findById(vehicleModelId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle model not found with ID:" + vehicleModelId));
    }
}
