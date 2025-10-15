package com.robozinho.investbot.repository;

import com.robozinho.investbot.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByStockSymbol(String symbol);
    
    List<Trade> findByStatus(String status);
    
    @Query("SELECT t FROM Trade t WHERE t.tradeDate BETWEEN :startDate AND :endDate")
    List<Trade> findTradesByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("SELECT t FROM Trade t WHERE t.type = :type AND t.status = 'PENDING'")
    List<Trade> findPendingTradesByType(String type);
}