package com.lesliefernsby.currencyexchange.Services;

import com.lesliefernsby.currencyexchange.Entities.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrenciesService {

    Optional<List<Currency>> getAll();
}
