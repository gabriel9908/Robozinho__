package com.robozinho.investbot.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AnalysisDTO {
    private String stockSymbol;
    private String trend;
    private String recommendation;
    private BigDecimal supportLevel;
    private BigDecimal resistanceLevel;
    private String technicalAnalysis;
    private String fundamentalAnalysis;
    private LocalDateTime analysisDate;
}