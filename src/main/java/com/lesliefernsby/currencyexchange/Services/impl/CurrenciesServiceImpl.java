package com.lesliefernsby.currencyexchange.Services.impl;

import com.lesliefernsby.currencyexchange.Entities.Currency;
import com.lesliefernsby.currencyexchange.Entities.ExchangeRate;
import com.lesliefernsby.currencyexchange.Repositories.CurrencyRepository;
import com.lesliefernsby.currencyexchange.Repositories.ExchangeRateRepository;
import com.lesliefernsby.currencyexchange.Services.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CurrenciesServiceImpl implements CurrenciesService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ExchangeRateRepository exchangeRateRepository;


    @Override
    public Optional<List<Currency>> getAll() {
        List<Currency> currencies = currencyRepository.getAll();
        return Optional.ofNullable(currencies);
    }


    @Override
    public Optional<Currency> getById(int id) {
        Currency currency = currencyRepository.getById(id);
        return Optional.ofNullable(currency);
    }

    @Override
    public Optional<Currency> getByCode(String code) {
        Currency currency = currencyRepository.getByCode(code.toUpperCase());
        return Optional.ofNullable(currency);
    }

    @Override
    public Optional<Integer> insertCurrency(String code, String full_name, String sign) {
        currencyRepository.insertCurrency(code.toUpperCase(), full_name, sign);
        Currency currency = currencyRepository.getByCode(code.toUpperCase());
        return Optional.ofNullable(currency.getId());
    }

    @Override
    public Optional<List<ExchangeRate>> getAllExchangeRates() {
        List<ExchangeRate> exchangeRates = exchangeRateRepository.findAll();
        return Optional.ofNullable(exchangeRates);
    }

    @Override
    public Optional<ExchangeRate> getExchangeRateByCodes(String from, String to) {
        ExchangeRate exchangeRate = exchangeRateRepository.findByCodes(from.toUpperCase(), to.toUpperCase());
        return Optional.ofNullable(exchangeRate);
    }
    
    @Override
    public Optional<ExchangeRate> insertExchangeRate(String from, String to, BigDecimal rate) {
        Currency fromCurrency = currencyRepository.getByCode(from.toUpperCase());
        Currency toCurrency = currencyRepository.getByCode(to.toUpperCase());
        exchangeRateRepository.insertExchangeRate(fromCurrency.getId(), toCurrency.getId(), rate);
        ExchangeRate exchangeRate = exchangeRateRepository.findByCodes(from.toUpperCase(), to.toUpperCase());
        return Optional.ofNullable(exchangeRate);
    }

    @Override
    public Optional<Integer> deleteExchangeRate(Integer id) {
        return Optional.ofNullable(exchangeRateRepository.deleteExchangeRate(id) ? id : null);
    }

}
