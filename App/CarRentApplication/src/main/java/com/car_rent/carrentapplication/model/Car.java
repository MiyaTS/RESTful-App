package com.car_rent.carrentapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    private String id; //UUID
    private int year;
    private String model;
    private String color;
    private String engine;
    private double rentPrice;
    private boolean isRented;
}
