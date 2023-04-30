package com.lesliefernsby.currencyexchange.Entities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExchangeRateRowMapper implements RowMapper<ExchangeRate> {

    @Override
    public ExchangeRate mapRow(ResultSet resultSet, int rowNum) throws SQLException {
      ExchangeRate exchangeRate = new ExchangeRate();
      exchangeRate.setId(resultSet.getInt("id"));
      exchangeRate.setRate(resultSet.getBigDecimal("rate"));

      Currency baseCurrency = new Currency();
      baseCurrency.setId(resultSet.getInt("base_currency_id"));
      baseCurrency.setCode(resultSet.getString("base_currency_code"));
      baseCurrency.setFullName(resultSet.getString("base_currency_full_name"));
      baseCurrency.setSign(resultSet.getString("base_currency_sign"));
      exchangeRate.setBaseCurrency(baseCurrency);

      Currency targetCurrency = new Currency();
      targetCurrency.setId(resultSet.getInt("target_currency_id"));
      targetCurrency.setCode(resultSet.getString("target_currency_code"));
      targetCurrency.setFullName(resultSet.getString("target_currency_full_name"));
      targetCurrency.setSign(resultSet.getString("target_currency_sign"));
      exchangeRate.setTargetCurrency(targetCurrency);

      return exchangeRate;
    }
}
