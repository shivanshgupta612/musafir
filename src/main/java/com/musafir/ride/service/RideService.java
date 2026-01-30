package com.musafir.ride.service;

import com.musafir.common.enums.RideStatus;
import com.musafir.common.exception.BusinessException;
import com.musafir.common.vo.Location;
import com.musafir.driver.entity.Vehicle;
import com.musafir.driver.service.DriverService;
import com.musafir.matching.service.MatchingService;
import com.musafir.ride.dto.RideRequestDto;
import com.musafir.ride.dto.RideResponseDto;
import com.musafir.ride.entity.Ride;
import com.musafir.ride.fare.FareCalculator;
import com.musafir.ride.repository.RideRepository;
import com.musafir.rider.entity.Rider;
import com.musafir.rider.repository.RiderRepository;
import com.musafir.rider.service.RiderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RideService {
    RiderService riderService;
    MatchingService matchingService;
    DriverService driverService;
    FareCalculator fareCalculator;
    RideRepository rideRepository;
    RiderRepository riderRepository;
    public RideService(RiderService riderService,MatchingService matchingService,DriverService driverService,FareCalculator fareCalculator, RideRepository rideRepository, RiderRepository riderRepository){
        this.riderService=riderService;
        this.matchingService=matchingService;
        this.driverService=driverService;
        this.fareCalculator=fareCalculator;
        this.rideRepository=rideRepository;
        this.riderRepository=riderRepository;
    }

    @Transactional
    public RideResponseDto requestRide(RideRequestDto req) {

        Rider rider = riderRepository.findById(req.riderId())
                .orElseThrow(() -> new BusinessException("Rider not found"));

        Ride ride = Ride.builder()
                .source(new Location(req.sourceLat(), req.sourceLon()))
                .destination(new Location(req.destLat(), req.destLon()))
                .fare(0L) // placeholder
                .status(RideStatus.REQUESTED)
                .rider(rider)
                .driver(null)
                .build();

        Ride saved = rideRepository.save(ride);

        return new RideResponseDto(
                saved.getId(),
                saved.getRider().getId(),
                null,
                saved.getSource().getLat(),
                saved.getSource().getLon(),
                saved.getDestination().getLat(),
                saved.getDestination().getLon(),
                saved.getStatus(),
                saved.getFare()
        );
    }


    private Double calculateFare(Location src,Location dest,Vehicle vehicle) {
        return fareCalculator.calculate(src,dest,vehicle.getVehicleType());
    }
}
