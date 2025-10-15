package com.robozinho.investbot.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class StockDTO {
    private String symbol;
    private String name;
    private String sector;
    private String segment;
    private BigDecimal currentPrice;
    private BigDecimal variation;
    private BigDecimal volume;
    private LocalDateTime lastUpdate;
}