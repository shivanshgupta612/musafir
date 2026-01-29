package com.musafir.rider.service;

import com.musafir.common.exception.BusinessException;
import com.musafir.rider.dto.RiderRegisterDto;
import com.musafir.rider.dto.RiderResponseDto;
import com.musafir.rider.dto.UpdateRiderInfoDto;
import com.musafir.rider.entity.Rider;
import com.musafir.rider.repository.RiderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RiderService {
    private final RiderRepository riderRepository;
    RiderService(RiderRepository riderRepository){
        this.riderRepository=riderRepository;
    }
    public RiderResponseDto registerRider(RiderRegisterDto request){
        if(riderRepository.existsByPhone(request.phone())){
            throw new BusinessException("Rider already registered");
        }
        Rider rider = Rider.builder()
                .name(request.name())
                .phone(request.phone())
                .build();
        Rider saved = riderRepository.save(rider);
        return new RiderResponseDto(saved.getId(),
                saved.getName(),
                saved.getPhone());
    }

//
    public RiderResponseDto getRider(Long riderId) {

        Rider rider = riderRepository.findById(riderId)
                .orElseThrow(() -> new BusinessException("Rider not found"));

        return new RiderResponseDto(
                rider.getId(),
                rider.getName(),
                rider.getPhone()
        );
    }


    @Transactional
    public RiderResponseDto updateRider(UpdateRiderInfoDto request) {

        Rider rider = riderRepository.findById(request.riderId())
                .orElseThrow(() -> new BusinessException("Rider not found"));

        if (!rider.getPhone().equals(request.newPhone())
                && riderRepository.existsByPhone(request.newPhone())) {
            throw new BusinessException("Phone already in use");
        }

        rider.setName(request.newName());
        rider.setPhone(request.newPhone());

        Rider saved = riderRepository.save(rider);

        return new RiderResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getPhone()
        );
    }
}
