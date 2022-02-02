package com.vok.vokbook.vehicle.controller.mapper;

import com.vok.vokbook.common.mapper.BaseMapper;
import com.vok.vokbook.vehicle.controller.dto.VehicleResponse;
import com.vok.vokbook.vehicle.domain.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper extends BaseMapper<Vehicle, VehicleResponse> {
}
