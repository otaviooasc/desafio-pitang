package com.carros.oasc.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "tb_car")
public class CarModel {
    @Id
    private String licensePlate;

    @Column(name = "car_year")
    private int year;

    private String model;

    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
