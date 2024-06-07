package com.carros.oasc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record UserDTO(@NotBlank String firstName,
                      @NotBlank String lastName,
                      @NotBlank String email,
                      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                      @NotNull LocalDate birthDay,
                      @NotBlank String login,
                      @NotBlank String password,
                      @NotBlank String phone) {
}
