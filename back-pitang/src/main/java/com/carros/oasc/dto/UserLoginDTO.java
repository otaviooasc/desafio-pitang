package com.carros.oasc.dto;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDTO(
        @NotBlank String login,
        @NotBlank String password
) {
}
