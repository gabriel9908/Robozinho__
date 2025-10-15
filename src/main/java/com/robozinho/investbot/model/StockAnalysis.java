package com.robozinho.investbot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class StockAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Stock stock;
    
    private BigDecimal supportLevel;
    private BigDecimal resistanceLevel;
    private String trend;
    private String recommendation;
    private LocalDateTime analysisDate;
    
    @Column(length = 2000)
    private String technicalAnalysis;
    
    @Column(length = 2000)
    private String fundamentalAnalysis;
}