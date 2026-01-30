package com.musafir.ride.fare;

import com.musafir.common.enums.VehicleType;
import com.musafir.common.exception.BusinessException;
import com.musafir.ride.fare.strategy.*;

public class FareStrategyFactory {
    public static IFareStrategy getFareStrategy(VehicleType vehicleType){
        return switch(vehicleType){
            case BIKE -> new BikeFareStrategy();
            case AUTO -> new AutoFareStrategy();
            case RICKSHAW -> new RickshawFareStrategy();
            case COMPACT -> new CompactFareStrategy();
            case SEDAN -> new SedanFareStrategy();
            case XL -> new XLFareStrategy();
            default -> throw new BusinessException("Unsupported vehicle type");
        };
    }
}
