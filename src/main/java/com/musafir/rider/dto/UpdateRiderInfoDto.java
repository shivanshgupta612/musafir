package com.musafir.rider.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UpdateRiderInfoDto(
        Long riderId,

        @NotBlank
        String newName,

        @Pattern(regexp = "^[0-9]{10}$")
        String newPhone
) {}

