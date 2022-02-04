package com.vok.vokbook.vehicle.controller;

import com.vok.vokbook.vehicle.controller.dto.VehicleDTO;
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
    public ResponseEntity<VehicleDTO.Response> create(@RequestBody VehicleDTO.CreateRequest request) {
        final Vehicle vehicle = createVehicle.execute(request);
        return ResponseEntity.ok(vehicleMapper.toDTO(vehicle));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO.Response>> getAll() {
        final List<Vehicle> vehicle = getVehicles.getAll();
        return ResponseEntity.ok(vehicleMapper.toDTO(vehicle));
    }

    @GetMapping("{vehicleId}")
    public ResponseEntity<VehicleDTO.Response> get(@PathVariable Long vehicleId) {
        final Vehicle vehicle = getVehicles.get(vehicleId);
        return ResponseEntity.ok(vehicleMapper.toDTO(vehicle));
    }
}
