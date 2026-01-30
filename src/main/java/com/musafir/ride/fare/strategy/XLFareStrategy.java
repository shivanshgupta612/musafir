package com.musafir.ride.fare.strategy;

import com.musafir.ride.fare.IFareStrategy;

public class XLFareStrategy implements IFareStrategy {
    private static final double BASE_FARE = 70;
    private static final double PER_KM_RATE = 20;

    @Override
    public double calculateFare(double distanceKm) {
        return BASE_FARE + (distanceKm * PER_KM_RATE);
    }
}
