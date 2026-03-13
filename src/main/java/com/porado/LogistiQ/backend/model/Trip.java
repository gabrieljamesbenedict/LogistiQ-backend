package com.porado.LogistiQ.backend.model;

import com.porado.LogistiQ.backend.util.TripStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @Column(nullable = false)
    private TripStatus tripStatus;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private Instant startedAt;

    @Column(nullable = false)
    private Instant endedAt;

    @OneToMany
    @JoinColumn(name = "employeeId")
    private List<Employee> employeeId;

    @Column
    private String cargoDescription;
}