package com.musafir.ride.fare.strategy;

import com.musafir.ride.fare.IFareStrategy;

public class RickshawFareStrategy implements IFareStrategy {
    private static final double BASE_FARE = 25;
    private static final double PER_KM_RATE = 7.5;

    @Override
    public double calculateFare(double distanceKm) {
        return BASE_FARE + (distanceKm * PER_KM_RATE);
    }
}
