package com.porado.LogistiQ.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime date;
    private String origin;
    private String destination;
    private String status; 
    private String driver;
    private Double totalExpenses;
    private Double totalProfit;
    private String customerName;
}