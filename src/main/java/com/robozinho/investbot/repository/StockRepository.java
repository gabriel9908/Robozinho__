package com.robozinho.investbot.repository;

import com.robozinho.investbot.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findBySymbol(String symbol);
    
    @Query("SELECT s FROM Stock s WHERE s.sector = :sector")
    List<Stock> findByIndustry(String sector);
    
    @Query("SELECT s FROM Stock s ORDER BY s.lastUpdate DESC")
    List<Stock> findMostRecentlyUpdated();
}