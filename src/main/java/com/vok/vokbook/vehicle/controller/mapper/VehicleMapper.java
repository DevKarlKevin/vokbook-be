package com.vok.vokbook.vehicle.controller.mapper;

import com.vok.vokbook.common.mapper.BaseMapper;
import com.vok.vokbook.vehicle.controller.dto.VehicleDTO;
import com.vok.vokbook.vehicle.controller.dto.VehiclePartDTO;
import com.vok.vokbook.vehicle.domain.Vehicle;
import com.vok.vokbook.vehicle.domain.VehiclePart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper extends BaseMapper<Vehicle, VehicleDTO.Response> {
    List<VehiclePartDTO> mapParts(List<VehiclePart> vehicleParts);
}
