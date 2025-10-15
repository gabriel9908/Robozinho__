package com.robozinho.investbot.service;

import com.robozinho.investbot.model.Stock;
import com.robozinho.investbot.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @Test
    void whenGetStockBySymbol_thenReturnStock() {
        // Arrange
        String symbol = "PETR4";
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setName("Petrobras PN");
        stock.setLastPrice(BigDecimal.valueOf(30.50));

        when(stockRepository.findBySymbol(symbol)).thenReturn(Optional.of(stock));

        // Act
        Stock result = stockService.getStockBySymbol(symbol);

        // Assert
        assertNotNull(result);
        assertEquals(symbol, result.getSymbol());
        assertEquals("Petrobras PN", result.getName());
        assertEquals(BigDecimal.valueOf(30.50), result.getLastPrice());
    }
}