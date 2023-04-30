package com.lesliefernsby.currencyexchange.Controllers;

import com.lesliefernsby.currencyexchange.DTO.CurrencyDTO;
import com.lesliefernsby.currencyexchange.DTO.ExchangeRateDTO;
import com.lesliefernsby.currencyexchange.Entities.Currency;
import com.lesliefernsby.currencyexchange.Entities.ExchangeRate;
import com.lesliefernsby.currencyexchange.Services.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping(path = "/currencies/{id}")
    public ResponseEntity<Currency> getById(@PathVariable Integer id) {
        Currency currency = service.getById(id).orElseThrow();
        return new ResponseEntity<>(currency, HttpStatus.OK);
    }

    @GetMapping(path = "/currencies/code/{code}")
    public ResponseEntity<Currency> getByCode(@PathVariable String code) {
        Currency currency = service.getByCode(code).orElseThrow();
        return new ResponseEntity<>(currency, HttpStatus.OK);
    }

    @PostMapping(path = "/currencies")
    public ResponseEntity<Integer> insert(@RequestBody CurrencyDTO currencyDTO) {
        Integer id = service.insertCurrency(currencyDTO.getCode(), currencyDTO.getFull_name(), currencyDTO.getSign()).orElseThrow();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @GetMapping(path = "/exchange-rates")
    public ResponseEntity<List<ExchangeRate>> getAllExchangeRates() {
        List<ExchangeRate> exchangeRates = service.getAllExchangeRates().orElseThrow();
        return new ResponseEntity<>(exchangeRates, HttpStatus.OK);
    }

    @GetMapping(path = "/exchange-rates/{from}/{to}")
    public ResponseEntity<ExchangeRate> getExchangeRateByCodes(@PathVariable String from, @PathVariable String to) {
        ExchangeRate exchangeRate = service.getExchangeRateByCodes(from, to).orElseThrow();
        return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
    }

    @PostMapping(path = "/exchange-rates")
    public ResponseEntity<ExchangeRate> insertExchangeRate(@RequestBody ExchangeRateDTO exchangeRate) {
        ExchangeRate id = service.insertExchangeRate(exchangeRate.getBaseCurrencyCode(), exchangeRate.getTargetCurrencyCode(), exchangeRate.getRate()).orElseThrow();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping(path = "/exchange-rates/{id}")
    public ResponseEntity<Integer> deleteExchangeRate(@PathVariable Integer id) {
        Integer deleted = service.deleteExchangeRate(id).orElseThrow();
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}
