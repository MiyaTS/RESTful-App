package com.admin.adminbackofficeapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rent_application")
public class RentApplication {
    @Id
    @SequenceGenerator(
            name = "rent_application_sequence",
            sequenceName = "rent_application_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rent_application_sequence"
    )
    private long id;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Client client;
    private int amountOfRentDays;
}
