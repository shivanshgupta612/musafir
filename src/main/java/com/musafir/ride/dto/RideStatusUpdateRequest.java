package com.musafir.ride.dto;

import com.musafir.common.enums.RideStatus;
import jakarta.validation.constraints.NotNull;

public record RideStatusUpdateRequest(

        @NotNull(message = "Status is required")
        RideStatus status

) {}
