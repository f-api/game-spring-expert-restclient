package com.example.rates.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Void> handleHttpError(
            HttpClientErrorException exception
    ) {
        log.info("외부 HTTP 오류: {}", exception.getStatusCode().value());
        return ResponseEntity.status(exception.getStatusCode()).build();
    }
}
