package com.lesliefernsby.currencyexchange.Services.impl;

import com.lesliefernsby.currencyexchange.Entities.Currency;
import com.lesliefernsby.currencyexchange.Entities.ExchangeRate;
import com.lesliefernsby.currencyexchange.Repositories.CurrencyRepository;
import com.lesliefernsby.currencyexchange.Repositories.ExchangeRateRepository;
import com.lesliefernsby.currencyexchange.Services.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<List<ExchangeRate>> getAllExchangeRates() {
        List<ExchangeRate> exchangeRates = exchangeRateRepository.findAll();
        return Optional.ofNullable(exchangeRates);
    }
}
