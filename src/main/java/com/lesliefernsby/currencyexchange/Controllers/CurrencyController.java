package com.lesliefernsby.currencyexchange.Controllers;

import com.lesliefernsby.currencyexchange.Entities.Currency;
import com.lesliefernsby.currencyexchange.Entities.ExchangeRate;
import com.lesliefernsby.currencyexchange.Services.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CurrencyController {

    @Autowired
    CurrenciesService service;

    @RequestMapping(path = "/is-alive")
    String isAlive() {
        return "Server is alive";
    }

    @GetMapping(path = "/currencies")
    public ResponseEntity<List<Currency>> getAll() {
        List<Currency> currencies = service.getAll().orElseThrow();
        return new ResponseEntity<>(currencies, HttpStatus.OK);
    }

    @GetMapping(path = "/exchange-rates")
    public ResponseEntity<List<ExchangeRate>> getAllExchangeRates() {
        List<ExchangeRate> exchangeRates = service.getAllExchangeRates().orElseThrow();
        return new ResponseEntity<>(exchangeRates, HttpStatus.OK);
    }
}
