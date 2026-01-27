package com.musafir.driver.dto;

import com.musafir.model.enums.DriverStatus;
import jakarta.validation.constraints.NotNull;

public record DriverStatusUpdateRequestDto(
        @NotNull(message = "Status is required")
        DriverStatus status
) {}
