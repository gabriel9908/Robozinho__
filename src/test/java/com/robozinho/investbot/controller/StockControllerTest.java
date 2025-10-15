package com.robozinho.investbot.controller;

import com.robozinho.investbot.dto.StockDTO;
import com.robozinho.investbot.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StockController.class)
public class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService stockService;

    @Test
    void whenGetAllStocks_thenReturnJsonArray() throws Exception {
        StockDTO stock = new StockDTO();
        stock.setSymbol("PETR4");
        stock.setCurrentPrice(BigDecimal.valueOf(30.50));

        when(stockService.getAllStocks()).thenReturn(Arrays.asList(stock));

        mockMvc.perform(get("/api/stocks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].symbol").value("PETR4"))
                .andExpect(jsonPath("$[0].currentPrice").value(30.50));
    }
}