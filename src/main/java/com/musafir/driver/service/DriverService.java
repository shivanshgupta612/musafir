package com.musafir.driver.service;

import com.musafir.common.enums.DriverStatus;
import com.musafir.common.exception.BusinessException;
import com.musafir.driver.dto.DriverRegisterRequestDto;
import com.musafir.driver.dto.DriverResponseDto;
import com.musafir.driver.entity.Driver;
import com.musafir.driver.entity.Vehicle;
import com.musafir.driver.repository.DriverRepository;
import com.musafir.driver.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    public DriverService(DriverRepository driverRepository, VehicleRepository vehicleRepository){
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public DriverResponseDto registerDriver(DriverRegisterRequestDto request){
        if(driverRepository.existsByPhone(request.phone())){
            throw new BusinessException("Driver with this phonenumber already exists");
        }
        if(vehicleRepository.existsByRegNo(request.vehicleRegNo())){
            throw new BusinessException("Driver with this vehicleRegNo already exists");
        }
        Driver driver = Driver.builder()
                .name(request.name())
                .phone(request.phone())
                .status(DriverStatus.OFFLINE)
                .build();
        Vehicle vehicle = Vehicle.builder()
                .driver(driver)
                .regNo(request.vehicleRegNo())
                .vehicleType(request.vehicleType())
                .build();
        driver.setVehicle(vehicle);
        Driver saved = driverRepository.save(driver);

        return new DriverResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getPhone(),
                saved.getStatus(),
                saved.getVehicle().getVehicleType(),
                saved.getVehicle().getRegNo()
        );
    }

    public Driver findDriver(Long id){
        return driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Driver not found"));
    }

    @Transactional
    public void setOnline(Long driverId){
        Driver driver = findDriver(driverId);
        driver.setStatus(DriverStatus.ONLINE);
    }

    @Transactional
    public void setOffline(Long driverId){
        Driver driver = findDriver(driverId);
        driver.setStatus(DriverStatus.OFFLINE);
    }
}
