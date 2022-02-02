package com.vok.vokbook.vehicle.repository;

import com.vok.vokbook.vehicle.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
