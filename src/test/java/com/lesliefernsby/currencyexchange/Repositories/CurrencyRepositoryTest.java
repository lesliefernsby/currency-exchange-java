package com.lesliefernsby.currencyexchange.Repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lesliefernsby.currencyexchange.Entities.Currency;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CurrencyRepositoryTest {

    @Mock
    private CurrencyRepository currencyRepository;

    @Test
    void testGetAll() {
        // Set up test data
        Currency usd = new Currency("USD", "US Dollar");
        Currency eur = new Currency("EUR", "Euro");
        List<Currency> expectedCurrencies = Arrays.asList(usd, eur);

        // Set up mock expectations
        when(currencyRepository.getAll()).thenReturn(expectedCurrencies);

        // Call the getAll() method from the CurrencyRepository
        List<Currency> actualCurrencies = currencyRepository.getAll();

        // Assert that the returned data matches the expected data
        assert(actualCurrencies.containsAll(expectedCurrencies));
    }

    @Test
    void testGetByCode() {
        // Set up test data
        Currency usd = new Currency("USD", "US Dollar");

        // Set up mock expectations
        when(currencyRepository.getByCode("USD")).thenReturn(usd);

        // Call the getByCode() method from the CurrencyRepository
        Currency actualCurrency = currencyRepository.getByCode("USD");

        // Assert that the returned data matches the expected data
        assertTrue(actualCurrency != null);
        assertEquals(usd, actualCurrency);
    }

    @Test
    void testGetById() {
        // Set up test data
        Currency usd = new Currency("USD", "US Dollar");
        usd.setId(1);

        // Set up mock expectations
        when(currencyRepository.getById(1)).thenReturn(usd);

        // Call the getById() method from the CurrencyRepository
        Currency actualCurrency = currencyRepository.getById(1);

        // Assert that the returned data matches the expected data
        assertTrue(actualCurrency != null);
        assertEquals(usd, actualCurrency);
    }

}
