package com.robozinho.investbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InvestBotApplication {
    public static void main(String[] args) {
        SpringApplication.run(InvestBotApplication.class, args);
    }
}