package com.robozinho.investbot.service;

import com.robozinho.investbot.model.Trade;
import com.robozinho.investbot.repository.TradeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {

    @Mock
    private TradeRepository tradeRepository;

    @InjectMocks
    private TradeService tradeService;

    @Test
    void whenExecuteBuyOrder_thenSaveTradeWithCorrectStatus() {
        // Arrange
        Trade trade = new Trade();
        trade.setType("BUY");
        trade.setQuantity(100);
        trade.setPrice(BigDecimal.valueOf(30.50));
        trade.setStatus("PENDING");
        trade.setTradeDate(LocalDateTime.now());

        when(tradeRepository.save(any(Trade.class))).thenReturn(trade);

        // Act
        Trade result = tradeService.executeBuyOrder("PETR4", 100, BigDecimal.valueOf(30.50));

        // Assert
        assertNotNull(result);
        assertEquals("BUY", result.getType());
        assertEquals("PENDING", result.getStatus());
        assertEquals(100, result.getQuantity());
        verify(tradeRepository, times(1)).save(any(Trade.class));
    }
}