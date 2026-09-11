package com.example.rates.service;

import com.example.rates.dto.ExchangeRateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
public class ExchangeRateClient {
    private final RestClient restClient;

    public ExchangeRateClient(
            RestClient.Builder builder,
            @Value("${rates.base-url}") String baseUrl
    ) {
        this.restClient = builder.baseUrl(baseUrl).build();
    }

    public ExchangeRateResponse fetch(
            String code
    ) {
        log.info("환율 API 호출: {}", code);
        return restClient.get()
                .uri("/rates/{code}.json", code)
                .retrieve()
                .body(ExchangeRateResponse.class);
    }
}
