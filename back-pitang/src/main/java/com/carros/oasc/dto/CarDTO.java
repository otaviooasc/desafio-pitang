package com.carros.oasc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarDTO(@NotNull int year,
                     @NotBlank String licensePlate,
                     @NotBlank String model,
                     @NotBlank String color)
{
}
