package com.carros.oasc.models;

import com.carros.oasc.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate birthDay;

    private String login;

    private String password;

    private String phone;

    @OneToMany(mappedBy = "user")
    private List<CarModel> cars;

    public UserModel(UserDTO userDTO) {
        this.firstName = userDTO.firstName();
        this.lastName = userDTO.lastName();
        this.email = userDTO.email();
        this.birthDay = userDTO.birthDay();
        this.login = userDTO.login();
        this.password = userDTO.password();
        this.phone = userDTO.phone();
    }
}
