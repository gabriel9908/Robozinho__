package com.robozinho.investbot.controller;

import com.robozinho.investbot.dto.AnalysisDTO;
import com.robozinho.investbot.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/analysis")
@RequiredArgsConstructor
public class AnalysisController {
    
    private final AnalysisService analysisService;
    
    @GetMapping("/{symbol}")
    public ResponseEntity<AnalysisDTO> getAnalysis(@PathVariable String symbol) {
        return ResponseEntity.ok(analysisService.getAnalysisForStock(symbol));
    }
    
    @GetMapping("/recommendation/{type}")
    public ResponseEntity<List<AnalysisDTO>> getAnalysisByRecommendation(@PathVariable String type) {
        return ResponseEntity.ok(analysisService.getAnalysisByRecommendation(type));
    }
    
    @PostMapping("/{symbol}")
    public ResponseEntity<AnalysisDTO> triggerAnalysis(@PathVariable String symbol) {
        return ResponseEntity.ok(analysisService.analyzeStock(symbol));
    }
}