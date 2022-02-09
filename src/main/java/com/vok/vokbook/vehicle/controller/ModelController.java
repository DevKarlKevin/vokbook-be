package com.vok.vokbook.vehicle.controller;

import com.vok.vokbook.vehicle.controller.dto.VehicleModelDTO;
import com.vok.vokbook.vehicle.controller.mapper.VehicleModelMapper;
import com.vok.vokbook.vehicle.domain.VehicleModel;
import com.vok.vokbook.vehicle.service.CreateVehicleModel;
import com.vok.vokbook.vehicle.service.GetVehicleModels;
import com.vok.vokbook.vehicle.service.UpdateVehicleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("models")
@RequiredArgsConstructor
public class ModelController {

    private final CreateVehicleModel createVehicleModel;
    private final GetVehicleModels getVehicleModels;
    private final VehicleModelMapper vehicleModelMapper;
    private final UpdateVehicleModel updateVehicleModel;

    @PostMapping
    public ResponseEntity<VehicleModelDTO.Response> create(@Valid @RequestBody VehicleModelDTO.CreateRequest request) {
        final VehicleModel model = createVehicleModel.execute(request);
        return ResponseEntity.ok(vehicleModelMapper.toDTO(model));
    }

    @GetMapping
    public ResponseEntity<List<VehicleModelDTO.Response>> getAll() {
        final List<VehicleModel> vehicleModels = getVehicleModels.getAll();
        return ResponseEntity.ok(vehicleModelMapper.toDTO(vehicleModels));
    }

    @GetMapping("{vehicleModelId}")
    public ResponseEntity<VehicleModelDTO.Response> get(@PathVariable Long vehicleModelId) {
        final VehicleModel vehicleModel = getVehicleModels.get(vehicleModelId);
        return ResponseEntity.ok(vehicleModelMapper.toDTO(vehicleModel));
    }

    @PutMapping("{vehicleModelId}")
    public ResponseEntity<VehicleModelDTO.Response> update(@PathVariable Long vehicleModelId, @Valid @RequestBody VehicleModelDTO.UpdateRequest request) {
        VehicleModel updatedVehicleModel = updateVehicleModel.execute(vehicleModelId, request);
        return ResponseEntity.ok(vehicleModelMapper.toDTO(updatedVehicleModel));
    }
}
