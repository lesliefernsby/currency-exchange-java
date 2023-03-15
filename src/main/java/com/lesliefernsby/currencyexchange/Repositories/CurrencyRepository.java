package com.lesliefernsby.currencyexchange.Repositories;

import com.lesliefernsby.currencyexchange.Entities.Currency;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

    @Query("SELECT * FROM currencies")
    public List<Currency> getAll();
}
