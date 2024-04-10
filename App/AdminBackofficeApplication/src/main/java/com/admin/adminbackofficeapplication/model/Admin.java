package com.admin.adminbackofficeapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    private String id; //UUID
    @Column(unique = true, nullable = false)
    private String mail;
    private String password;
    private String name;
}
