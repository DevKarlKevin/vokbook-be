package com.vok.vokbook.vehicle.service;

import com.vok.vokbook.vehicle.domain.Vehicle;
import com.vok.vokbook.vehicle.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetVehicles {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle get(Long vehicleId) {
        return vehicleRepository.getById(vehicleId);
    }
}
