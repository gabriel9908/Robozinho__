package com.robozinho.investbot.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Stock stock;
    
    private String type; // BUY or SELL
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal totalValue;
    private LocalDateTime tradeDate;
    private String strategy;
    private String status; // PENDING, EXECUTED, CANCELLED
    
    @Column(length = 1000)
    private String notes;
}