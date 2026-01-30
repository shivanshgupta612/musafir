package com.musafir.ride.fare;

import com.musafir.common.enums.VehicleType;
import com.musafir.common.util.DistanceCalculator;
import com.musafir.common.vo.Location;

public class FareCalculator {
    public static double calculate(Location source,
                                   Location destination,
                                   VehicleType vehicleType) {

        double distanceKm = DistanceCalculator.calculateKm(source, destination);
        IFareStrategy fareStrategy = FareStrategyFactory.getFareStrategy(vehicleType);

        return fareStrategy.calculateFare(distanceKm);
    }
}
