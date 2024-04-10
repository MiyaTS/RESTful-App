package com.admin.adminbackofficeapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
