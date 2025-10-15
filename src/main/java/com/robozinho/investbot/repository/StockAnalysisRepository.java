package com.robozinho.investbot.repository;

import com.robozinho.investbot.model.StockAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface StockAnalysisRepository extends JpaRepository<StockAnalysis, Long> {
    List<StockAnalysis> findByStockSymbol(String symbol);
    
    @Query("SELECT sa FROM StockAnalysis sa WHERE sa.analysisDate >= :startDate")
    List<StockAnalysis> findRecentAnalysis(LocalDateTime startDate);
    
    @Query("SELECT sa FROM StockAnalysis sa WHERE sa.recommendation = :recommendation")
    List<StockAnalysis> findByRecommendation(String recommendation);
}