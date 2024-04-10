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
