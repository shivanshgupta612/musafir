package com.musafir.rider.dto;

public record RiderResponseDto(
        Long id,
        String name,
        String phone,
        Double rating
) {}
