package com.musafir.ride.dto;

import com.musafir.model.enums.RideStatus;

public record RideResponseDto(

        Long rideId,
        Long riderId,
        Long driverId,
        double sourceLat,
        double sourceLon,
        double destLat,
        double destLon,
        RideStatus status,
        Long fare

) {
}
