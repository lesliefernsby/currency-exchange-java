package com.lesliefernsby.currencyexchange.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ExchangeRateDTO {

  private String baseCurrencyCode;
  private String targetCurrencyCode;
  private BigDecimal rate;
  
}
