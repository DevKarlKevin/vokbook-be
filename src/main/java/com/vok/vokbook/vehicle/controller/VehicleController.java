package com.vok.vokbook.vehicle.controller;

import com.vok.vokbook.vehicle.controller.dto.VehicleCreateRequest;
import com.vok.vokbook.vehicle.controller.dto.VehicleResponse;
import com.vok.vokbook.vehicle.controller.mapper.VehicleMapper;
import com.vok.vokbook.vehicle.domain.Vehicle;
import com.vok.vokbook.vehicle.service.CreateVehicle;
import com.vok.vokbook.vehicle.service.GetVehicles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final CreateVehicle createVehicle;
    private final GetVehicles getVehicles;
    private final VehicleMapper vehicleMapper;

    @PostMapping
    public ResponseEntity<VehicleResponse> createVehicle(@RequestBody VehicleCreateRequest request) {
        final Vehicle vehicle = createVehicle.execute(request);
        return ResponseEntity.ok(vehicleMapper.toDTO(vehicle));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getAllVehicles() {
        final List<Vehicle> vehicle = getVehicles.execute();
        return ResponseEntity.ok(vehicleMapper.toDTO(vehicle));
    }
}
