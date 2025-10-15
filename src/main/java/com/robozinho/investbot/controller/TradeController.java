package com.robozinho.investbot.controller;

import com.robozinho.investbot.dto.TradeDTO;
import com.robozinho.investbot.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trades")
@RequiredArgsConstructor
public class TradeController {
    
    private final TradeService tradeService;
    
    @GetMapping
    public ResponseEntity<List<TradeDTO>> getAllTrades() {
        return ResponseEntity.ok(tradeService.getAllTrades());
    }
    
    @GetMapping("/{symbol}")
    public ResponseEntity<List<TradeDTO>> getTradesBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(tradeService.getTradesBySymbol(symbol));
    }
    
    @PostMapping
    public ResponseEntity<TradeDTO> executeTrade(@RequestBody TradeDTO tradeDTO) {
        return ResponseEntity.ok(tradeService.executeTrade(tradeDTO));
    }
    
    @PutMapping("/{id}/cancel")
    public ResponseEntity<TradeDTO> cancelTrade(@PathVariable Long id) {
        return ResponseEntity.ok(tradeService.cancelTrade(id));
    }
}