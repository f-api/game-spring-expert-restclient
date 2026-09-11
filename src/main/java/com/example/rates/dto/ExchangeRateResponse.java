package com.example.rates.dto;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class ExchangeRateResponse {
    private String code;
    private BigDecimal rate;
}
