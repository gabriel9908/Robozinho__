package com.robozinho.investbot.util;

import lombok.experimental.UtilityClass;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

@UtilityClass
public class NumberUtils {
    
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");
    
    public BigDecimal parseBrazilianNumber(String number) {
        try {
            DECIMAL_FORMAT.setParseBigDecimal(true);
            return (BigDecimal) DECIMAL_FORMAT.parse(number.replace("R$", "").trim());
        } catch (ParseException e) {
            throw new RuntimeException("Erro ao converter número: " + number, e);
        }
    }
    
    public String formatCurrency(BigDecimal value) {
        return "R$ " + DECIMAL_FORMAT.format(value);
    }
}