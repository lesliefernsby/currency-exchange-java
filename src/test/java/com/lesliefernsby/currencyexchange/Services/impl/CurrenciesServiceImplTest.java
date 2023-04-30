package com.lesliefernsby.currencyexchange.Services.impl;

import com.lesliefernsby.currencyexchange.Entities.Currency;
import com.lesliefernsby.currencyexchange.Repositories.CurrencyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrenciesServiceImplTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrenciesServiceImpl currenciesService;

    @Test
    void testGetAll() {
        // Set up test data
        Currency usd = new Currency("USD", "US Dollar");
        Currency eur = new Currency("EUR", "Euro");
        List<Currency> expectedCurrencies = Arrays.asList(usd, eur);

        // Set up mock expectations
        when(currencyRepository.getAll()).thenReturn(expectedCurrencies);

        // Call the getAll() method from the CurrenciesServiceImpl
        Optional<List<Currency>> actualCurrencies = currenciesService.getAll();

        // Assert that the returned data matches the expected data
        assertEquals(Optional.of(expectedCurrencies), actualCurrencies);
    }
}

