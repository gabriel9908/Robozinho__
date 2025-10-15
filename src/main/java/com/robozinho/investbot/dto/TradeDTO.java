package com.robozinho.investbot.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TradeDTO {
    private String stockSymbol;
    private String type;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal totalValue;
    private String strategy;
    private LocalDateTime executionDate;
    private String status;
}