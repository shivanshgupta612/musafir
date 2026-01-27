package com.musafir.ride.dto;

import jakarta.validation.constraints.NotNull;

public record RideRequestDto(
        @NotNull(message = "Rider ID is required")
        Long riderId,

        @NotNull(message = "Source latitude is required")
        Double sourceLat,

        @NotNull(message = "Source longitude is required")
        Double sourceLon,

        @NotNull(message = "Destination latitude is required")
        Double destLat,

        @NotNull(message = "Destination longitude is required")
        Double destLon

) {}
