package com.musafir.driver.dto;

import com.musafir.common.enums.DriverStatus;
import com.musafir.common.enums.VehicleType;

public record DriverResponseDto(
        Long id,
        String name,
        String phone,
        DriverStatus status,
        VehicleType vehicleType,
        String vehicleRegNo
) {}
