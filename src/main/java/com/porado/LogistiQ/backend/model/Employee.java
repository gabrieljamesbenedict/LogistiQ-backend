package com.porado.LogistiQ.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String middlename;

    @Column(nullable = false)
    private String licenseNumber;

    @Column
    private String contactNumber;

    @Column
    private String email;
}