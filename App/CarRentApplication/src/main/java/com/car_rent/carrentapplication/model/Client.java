package com.car_rent.carrentapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    private String id; //UUID
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String state;
    private String passport;
    private double bills;
}
