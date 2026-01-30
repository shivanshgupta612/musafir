package com.musafir.ride.fare.strategy;

import com.musafir.ride.fare.IFareStrategy;

public class SedanFareStrategy implements IFareStrategy {
    private static final double BASE_FARE = 50;
    private static final double PER_KM_RATE = 15;

    @Override
    public double calculateFare(double distanceKm) {
        return BASE_FARE + (distanceKm * PER_KM_RATE);
    }
}
