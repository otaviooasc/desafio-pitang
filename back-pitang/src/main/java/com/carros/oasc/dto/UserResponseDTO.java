package com.carros.oasc.dto;

import com.carros.oasc.models.UserModel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDTO {
    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDay;

    private String phone;

    public UserResponseDTO(UserModel user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.birthDay = user.getBirthDay();
        this.phone = user.getPhone();
    }
}
