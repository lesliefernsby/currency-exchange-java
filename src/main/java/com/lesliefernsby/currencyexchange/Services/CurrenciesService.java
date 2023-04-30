package com.lesliefernsby.currencyexchange.Services;

import com.lesliefernsby.currencyexchange.Entities.Currency;
import com.lesliefernsby.currencyexchange.Entities.ExchangeRate;

import java.util.List;
import java.util.Optional;

public interface CurrenciesService {

    Optional<List<Currency>> getAll();

    Optional<List<ExchangeRate>> getAllExchangeRates();
}
