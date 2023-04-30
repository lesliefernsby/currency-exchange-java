package com.lesliefernsby.currencyexchange.Services;

import com.lesliefernsby.currencyexchange.Entities.Currency;
import com.lesliefernsby.currencyexchange.Entities.ExchangeRate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CurrenciesService {

    Optional<List<Currency>> getAll();
    Optional<Currency> getById(int id);
    Optional<Currency> getByCode(String code);
    Optional<Integer> insertCurrency(String code, String full_name, String sign);

    Optional<List<ExchangeRate>> getAllExchangeRates();
    Optional<ExchangeRate> getExchangeRateByCodes(String from, String to);
    Optional<ExchangeRate> insertExchangeRate(String from, String to, BigDecimal rate);
    Optional<Integer> deleteExchangeRate(Integer id);
}
