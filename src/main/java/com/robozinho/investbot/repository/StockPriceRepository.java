package com.robozinho.investbot.repository;

import com.robozinho.investbot.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
    // Métodos personalizados podem ser adicionados aqui
}