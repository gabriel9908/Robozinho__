package com.robozinho.investbot.service;

import com.robozinho.investbot.model.StockPrice;
import com.robozinho.investbot.repository.StockPriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockScrapingService {

    private final StockPriceRepository repository;
    private static final String STOCK_URL = "https://br.investing.com/equities/brazil";

    @Scheduled(fixedDelay = 300000) // Executa a cada 5 minutos
    public void scrapeStockPrices() {
        try {
            Document doc = Jsoup.connect(STOCK_URL)
                    .userAgent("Mozilla/5.0")
                    .get();

            // Exemplo de scraping (ajuste os seletores conforme o site alvo)
            doc.select("tr.instrument-row").forEach(row -> {
                try {
                    StockPrice stock = new StockPrice();
                    stock.setSymbol(row.select("td.symbol").text());
                    stock.setPrice(new BigDecimal(row.select("td.price").text().replace(",", ".")));
                    stock.setVariation(new BigDecimal(row.select("td.variation").text().replace("%", "").replace(",", ".")));
                    stock.setTimestamp(LocalDateTime.now());
                    stock.setSource("Investing.com");

                    repository.save(stock);
                    log.info("Preço atualizado para {}: {}", stock.getSymbol(), stock.getPrice());
                } catch (Exception e) {
                    log.error("Erro ao processar linha: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            log.error("Erro ao fazer scraping: " + e.getMessage());
        }
    }
}