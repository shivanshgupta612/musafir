package com.musafir.driver.repository;

import com.musafir.driver.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    boolean existsByRegNo(String vehicleRegNo);
}
