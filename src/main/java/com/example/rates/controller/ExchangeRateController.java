package com.example.rates.controller;

import com.example.rates.dto.ExchangeRateResponse;
import com.example.rates.service.ExchangeRateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateClient exchangeRateClient;

    @GetMapping("/rates/{code}")
    public ResponseEntity<ExchangeRateResponse> findByCode(
            @PathVariable String code
    ) {
        return ResponseEntity.ok(exchangeRateClient.fetch(code));
    }
}
