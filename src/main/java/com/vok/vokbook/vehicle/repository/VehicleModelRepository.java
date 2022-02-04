package com.vok.vokbook.vehicle.repository;

import com.vok.vokbook.vehicle.domain.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
}
