package com.musafir.driver.dto;

import com.musafir.model.enums.DriverStatus;
import com.musafir.model.enums.VehicleType;

public record DriverResponseDto(
        Long id,
        String name,
        String phone,
        DriverStatus status,
        VehicleType vehicleType,
        String vehicleRegNo
) {}
