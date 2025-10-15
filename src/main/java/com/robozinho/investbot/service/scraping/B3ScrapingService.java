package com.robozinho.investbot.service.scraping;

import com.robozinho.investbot.model.Stock;
import com.robozinho.investbot.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class B3ScrapingService {
    
    private final StockRepository stockRepository;
    private static final String B3_URL = "http://www.b3.com.br/pt_br/market-data-e-indices/servicos-de-dados/market-data/cotacoes/";
    
    public List<Stock> scrapeStockList() {
        List<Stock> stocks = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(B3_URL)
                    .userAgent("Mozilla/5.0")
                    .get();
                    
            doc.select("table.quotations tr").forEach(row -> {
                Stock stock = new Stock();
                // Implementação do parsing dos dados
                stocks.add(stock);
            });
            
        } catch (IOException e) {
            log.error("Erro ao fazer scraping da B3: ", e);
        }
        return stocks;
    }
    
    public void updateStockPrices() {
        // Implementação da atualização de preços
    }
}