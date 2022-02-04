package com.vok.vokbook.vehicle.controller.mapper;

import com.vok.vokbook.common.mapper.BaseMapper;
import com.vok.vokbook.vehicle.controller.dto.VehicleModelDTO;
import com.vok.vokbook.vehicle.controller.dto.ModelPartDTO;
import com.vok.vokbook.vehicle.domain.VehicleModelPart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleModelMapper extends BaseMapper<com.vok.vokbook.vehicle.domain.VehicleModel, VehicleModelDTO.Response> {

    List<ModelPartDTO> mapModelParts(List<VehicleModelPart> vehicleModelParts);
}
