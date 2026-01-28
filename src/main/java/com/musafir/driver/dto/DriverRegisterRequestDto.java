package com.musafir.driver.dto;

import com.musafir.common.enums.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DriverRegisterRequestDto(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Phone is required")
        @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be a 10-digit number")
        String phone,

        VehicleType vehicleType,

        @NotBlank(message = "Vehicle registration number is required")
        String vehicleRegNo
) {}
