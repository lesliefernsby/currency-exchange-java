package com.lesliefernsby.currencyexchange.Repositories;

import com.lesliefernsby.currencyexchange.Entities.ExchangeRate;
import com.lesliefernsby.currencyexchange.Entities.ExchangeRateRowMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@RepositoryRestResource
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Integer> {

    @Query(value = "SELECT er.id as id, er.rate as rate, " +
           "bc.id as base_currency_id, bc.code as base_currency_code, bc.full_name as base_currency_full_name, bc.sign as base_currency_sign, " +
           "tc.id as target_currency_id, tc.code as target_currency_code, tc.full_name as target_currency_full_name, tc.sign as target_currency_sign " +
           "FROM exchange_rates er " +
           "JOIN currencies bc ON er.base_currency_id = bc.id " +
           "JOIN currencies tc ON er.target_currency_id = tc.id",
           rowMapperClass = ExchangeRateRowMapper.class)
    public List<ExchangeRate> findAll();
}
