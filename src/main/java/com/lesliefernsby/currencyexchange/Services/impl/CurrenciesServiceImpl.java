package com.lesliefernsby.currencyexchange.Services.impl;

import com.lesliefernsby.currencyexchange.Entities.Currency;
import com.lesliefernsby.currencyexchange.Repositories.CurrencyRepository;
import com.lesliefernsby.currencyexchange.Services.CurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrenciesServiceImpl implements CurrenciesService {

    @Autowired
    CurrencyRepository repository;


    @Override
    public Optional<List<Currency>> getAll() {
        List<Currency> currencies = repository.getAll();
        return Optional.ofNullable(currencies);
    }
}
