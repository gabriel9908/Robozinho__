package com.robozinho.investbot.controller;

import com.robozinho.investbot.model.StockPrice;
import com.robozinho.investbot.repository.StockPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockPriceRepository repository;

    @GetMapping
    public ResponseEntity<List<StockPrice>> getAllStockPrices() {
        return ResponseEntity.ok(repository.findAll());
    }
}