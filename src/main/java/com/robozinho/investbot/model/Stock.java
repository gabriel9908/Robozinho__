package com.robozinho.investbot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String symbol;
    private String name;
    private String sector;
    private String segment;
    private BigDecimal lastPrice;
    private LocalDateTime lastUpdate;
    
    @Column(length = 1000)
    private String description;
}