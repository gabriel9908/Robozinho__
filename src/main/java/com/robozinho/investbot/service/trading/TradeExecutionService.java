package com.robozinho.investbot.service.trading;

import com.robozinho.investbot.model.Stock;
import com.robozinho.investbot.model.Trade;
import com.robozinho.investbot.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TradeExecutionService {
    
    private final TradeRepository tradeRepository;
    
    public Trade executeBuyOrder(Stock stock, int quantity, BigDecimal limitPrice) {
        Trade trade = new Trade();
        trade.setStock(stock);
        trade.setType("BUY");
        trade.setQuantity(quantity);
        trade.setPrice(limitPrice);
        trade.setTotalValue(limitPrice.multiply(BigDecimal.valueOf(quantity)));
        trade.setTradeDate(LocalDateTime.now());
        trade.setStatus("PENDING");
        
        return tradeRepository.save(trade);
    }
    
    public Trade executeSellOrder(Stock stock, int quantity, BigDecimal limitPrice) {
        Trade trade = new Trade();
        trade.setStock(stock);
        trade.setType("SELL");
        trade.setQuantity(quantity);
        trade.setPrice(limitPrice);
        trade.setTotalValue(limitPrice.multiply(BigDecimal.valueOf(quantity)));
        trade.setTradeDate(LocalDateTime.now());
        trade.setStatus("PENDING");
        
        return tradeRepository.save(trade);
    }
    
    public void updateTradeStatus(Long tradeId, String status) {
        tradeRepository.findById(tradeId).ifPresent(trade -> {
            trade.setStatus(status);
            tradeRepository.save(trade);
        });
    }
}