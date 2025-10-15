package com.robozinho.investbot.service.trading;

import com.robozinho.investbot.model.Stock;
import com.robozinho.investbot.model.StockAnalysis;
import com.robozinho.investbot.service.analysis.TechnicalAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TradingStrategyService {
    
    private final TechnicalAnalysisService technicalAnalysisService;
    private final TradeExecutionService tradeExecutionService;
    
    public void executeMovingAverageCrossoverStrategy(Stock stock, List<StockPrice> prices) {
        BigDecimal sma20 = technicalAnalysisService.calculateSMA(prices, 20);
        BigDecimal sma50 = technicalAnalysisService.calculateSMA(prices, 50);
        
        if (sma20.compareTo(sma50) > 0) {
            // Sinal de compra
            tradeExecutionService.executeBuyOrder(stock, calculatePositionSize(stock), stock.getLastPrice());
        } else if (sma20.compareTo(sma50) < 0) {
            // Sinal de venda
            tradeExecutionService.executeSellOrder(stock, calculatePositionSize(stock), stock.getLastPrice());
        }
    }
    
    private int calculatePositionSize(Stock stock) {
        // Implementação do cálculo do tamanho da posição
        return 100; // Placeholder
    }
    
    public void executeRSIStrategy(Stock stock, List<StockPrice> prices) {
        // Implementação da estratégia baseada em RSI
    }
}